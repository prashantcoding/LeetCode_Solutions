//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[]vs=new boolean[V];
        boolean[]vp=new boolean[V];
        for(int i=0;i<V;i++){
            vs[i]=false;
            vp[i]=false;
        }
        for(int i=0;i<V;i++){
            
            if(!vs[i]){
                if(dfs(i,adj,vs,vp)==true) return true;
            }
            
           
            
        }
        return false;
    }
    boolean dfs(int V,ArrayList<ArrayList<Integer>>adj,boolean[]vs,boolean[] vp){
        vs[V]=true;
        vp[V]=true;
        
        ArrayList<Integer> neighbour=adj.get(V);
        
        for(int x:neighbour){
            if(!vs[x]){
               if(dfs(x,adj,vs,vp)==true)return true;
            }
            else{
                if(vp[x]) return true;
            }
            
        }
        vp[V]=false;
        return false;
    }
}