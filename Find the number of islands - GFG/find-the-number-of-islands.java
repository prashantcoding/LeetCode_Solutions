//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first,second;
    Pair(int a,int b){
        first=a;
        second=b;
    }

}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        Boolean[][]visited=new Boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                visited[i][j]=false;
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    count++;

                    BFS(grid,visited,i,j);
                }
            }
        }
        return count;
    }
    void BFS(char[][] grid, Boolean[][] visited, int row, int col){

        visited[row][col]=true;
        Queue<Pair> Q=new LinkedList<Pair>();
        Q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        while(!Q.isEmpty()){


            int ro=Q.peek().first;
            int co=Q.peek().second;
            Q.remove();

            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=delrow+ro;

                    int ncol=delcol+co;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && visited[nrow][ncol] == false
                    ) {

                        visited[nrow][ncol]=true;
                        Q.add(new Pair(nrow,ncol));
                    }

                }
            }


        }

    }
    
}
