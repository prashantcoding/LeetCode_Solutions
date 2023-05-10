//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    int[] rD = {1, 0, -1, 0};
    int[] rC = {0, 1, 0, -1};
    Set<String> ans = new HashSet<>();

    int countDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    Pair base = new Pair(i, j);
                    ArrayList<Pair> iland = new ArrayList<>();
                    BFS(i, j, visited, grid, iland);
                    ans.add(GenString(iland, base));

                }
            }
        }
        return ans.size();

    }

    void print(ArrayList<Pair> arr) {
        for (Pair x : arr) {
            System.out.print(" " + x.row + x.col + " ");
        }
        System.out.println("End");
        System.out.println();
    }

    String GenString(ArrayList<Pair> iland, Pair Base) {
        String distint = new String();
        for (Pair x : iland) {
            distint += ((x.row - Base.row) + " " + (x.col - Base.col));

        }
        return distint;
    }

    private void BFS(int r, int c, boolean[][] visited, int[][] grid, ArrayList<Pair> iland) {
        if (visited[r][c]) return;
        else {

            iland.add(new Pair(r, c));
            visited[r][c] = true;
            for (int i = 0; i < rD.length; i++) {
                int nr = r + rD[i];
                int nc = c + rC[i];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    BFS(nr, nc, visited, grid, iland);
                }


            }
        }
    }
}

