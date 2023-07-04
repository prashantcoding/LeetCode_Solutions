//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class SortWeight implements Comparator<Item>{
    public int compare(Item p, Item q) {
    double ratioP = (double) p.value / p.weight;
    double ratioQ = (double) q.value / q.weight;
    
    if (ratioP < ratioQ) {
        return 1;
    } else if (ratioP > ratioQ) {
        return -1;
    }
    return 0;
}
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        ArrayList<Item> ar=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ar.add(arr[i]);
        }
        SortWeight obj=new SortWeight();
        Collections.sort(ar,obj);
        int i=0;
        double profit=0;
        while(i<n&&W>0){
            
            int dw=ar.get(i).weight;
            if(W>=dw){
               
                profit+= ar.get(i).value;
                W=W-dw;
                i++;
            }
            else{
                
                 
                profit+=  W*(ar.get(i).value/(double)dw);
                
                W=0;
                break;
            }
            
            
        }
        return profit;
    }
}