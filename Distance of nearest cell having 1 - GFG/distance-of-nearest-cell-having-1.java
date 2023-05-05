//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;

    int step;

    Pair(int row,int col,int step){
        this.row=row;
        this.col=col;
        this.step=step;

    }
}
class Solution
{
    
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        

            Queue<Pair>Q=new LinkedList<>();
        Boolean[][]visited=new Boolean[grid.length][grid[0].length];
        int [][]ans=new int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    visited[i][j]=false;
                    ans[i][j]=0;
                    if(grid[i][j]==1){
                        Q.add(new Pair(i,j,0));
                        visited[i][j]=true;
                        ans[i][j]=0;
                    }

                }
            }
            int[]directions={-1,1};




            while(!Q.isEmpty()){
                Pair p=Q.poll();

                for(int i=0;i<directions.length;i++){
                    int row=p.row+directions[i];
                    int col=p.col;

                    if(row>=0&&row<grid.length&&!visited[row][col]){
                        if(grid[row][col]==0){
                            
                            ans[row][col]=p.step+1;
                            visited[row][col]=true;
                           
                            Q.add(new Pair(row,col,p.step+1));
                        }
                    }

                }

                for(int i=0;i<directions.length;i++){
                    int row=p.row;
                    int col=p.col+directions[i];

                    if(col>=0&&col<grid[0].length&&!visited[row][col]){

                        if(grid[row][col]==0){

                            ans[row][col]=p.step+1;
                            visited[row][col]=true;
                            Q.add(new Pair(row,col,p.step+1));
                        }
                    }
                }


            }
        return ans;
    }
}