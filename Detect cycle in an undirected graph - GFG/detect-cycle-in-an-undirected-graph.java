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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to detect cycle in an undirected graph.
    
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        Boolean[]visited=new Boolean[V];
        for(int i=0;i<V;i++) visited[i]=false;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(DFS(adj,i,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    static Boolean DFS(ArrayList<ArrayList<Integer>>adj,int start,int parent,Boolean []visited){
            // checking if the current node is visited or not

            // mark it visited

            // Now we need to check for the adjacent nodes
             visited[start]=true;
            // Now we need to check for the adjacent nodes
            for(int x:adj.get(start)){

                // if it is visited but it is the parent therefore do nothing
               if(visited[x]==false){
                   if(DFS(adj,x,start,visited)==true) return true;

               }
               else if(x!=parent) return true;
            }
            return false;
        }
    }
