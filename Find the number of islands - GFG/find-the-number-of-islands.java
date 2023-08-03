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
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }

}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        return solve(grid);
    }
    
     int solve(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean [][]visited=new boolean [m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && grid[i][j]=='1' ){
                        cnt++;
                        bfs(grid,visited,i,j);
                        

                }
            }
        }
        return cnt;
    }

    void bfs(char [][]grid,boolean[][]visited,int i,int j){
        
        Queue<Pair>Q=new LinkedList<>();
        Q.add(new Pair(i,j));
        while(!Q.isEmpty()){
            Pair temp=Q.poll();
            int row=temp.r;
            int col=temp.c;
                for(int delrow=-1;delrow<=1;delrow++){
                    for(int delcol=-1;delcol<=1;delcol++){
                        int nrow=row+delrow;
                        int ncol=col+delcol;
        if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==false && grid[nrow][ncol]=='1'
                        ){
                            visited[nrow][ncol]=true;
                              Q.add(new Pair(nrow,ncol));
                        }
                    }
                }
            
        }
    }
}