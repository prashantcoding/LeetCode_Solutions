//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int N){
        int i=0; // start index
        int j=0; // end index
       
        int n=N; // array size;
        long sum=0;
        long max=0;
        int ws=0;
         while(j<n){
            sum+=arr.get(j);
            if(j-i+1!=k){
                j++;
            }
            else if(j-i+1==k){
                
                max=Math.max(max,sum);
                sum=sum-arr.get(i);
                i++;
                j++;
            }
        }
        
        max=Math.max(max,sum);
        return max;
    }
}