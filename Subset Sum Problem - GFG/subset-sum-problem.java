//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        int [][]dp=new int [N+1][sum+1];
        for(int[]x:dp){
            Arrays.fill(x,-1);
        }
        return subsetSumDp(N,arr,sum,arr.length,dp)==1;
    }
    static int subsetSumDp(int N,int []arr,int sum ,int ind,int [][]dp ){
        if(sum==0) return 1;
        if(ind==0) return 0;
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        if(sum>=arr[ind-1]){
          if( subsetSumDp(N,arr,sum-arr[ind-1],ind-1,dp)==1 || subsetSumDp(N,arr,sum,ind-1,dp)==1){
              return dp[ind][sum]=1;
          }
          else return dp[ind][sum]=0;
        }
        else{
            return dp[ind][sum]=subsetSumDp(N,arr,sum,ind-1,dp);
        }
    }
}