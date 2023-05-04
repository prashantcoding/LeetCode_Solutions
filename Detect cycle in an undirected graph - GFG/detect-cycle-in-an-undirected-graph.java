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

class Pair{
    int i;
    int from=-1;
    Pair(int i,int from){
        this.i=i;

        this.from=from;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Boolean[]visited=new Boolean[V];
        for(int i=0;i<V;i++){
            visited[i]=false;
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(BFS(adj,visited,i)) return true;
            }
        }
        return false;
    }
    static boolean BFS(ArrayList<ArrayList<Integer>> adj, Boolean[] visited, int i){
            visited[i]=true;
            Queue<Pair>Q=new LinkedList<>();
            // Queue including the Pari
            Q.add(new Pair(i,-1));
            while(!Q.isEmpty()){

                Pair top=Q.poll();
                visited[top.i]=true;
                ArrayList<Integer>conn=adj.get(top.i);
                for(int z:conn){

                    if(visited[z]==true&&z!=top.from) return true;
                    else if(top.from!=z) Q.add(new Pair(z,top.i));

                }

            }
            return false;


    }
}