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
        int [][]dp=new int[N+1][sum+1];
        for(int []x:dp){
            Arrays.fill(x,-1);
        }
        isSubsetSumM(N,  arr,  sum,dp);
        return (dp[N][sum]==1)?true:false; 
    }
      static int isSubsetSumM(int N, int arr[], int sum,int [][]dp){
        if(sum==0) return 1;
        if(N==0) return 0;
        if(dp[N][sum]!=-1)return dp[N][sum];
        
        
        if(sum >= arr[N-1]){
             if(isSubsetSumM(N-1,arr,sum-arr[N-1],dp)==0&&isSubsetSumM(N-1,arr,sum,dp)==0){
              return dp[N][sum]=0;
                }
            else return dp[N][sum]=1;
        }
        else return dp[N][sum]=isSubsetSumM(N-1,arr,sum,dp);
    }
}