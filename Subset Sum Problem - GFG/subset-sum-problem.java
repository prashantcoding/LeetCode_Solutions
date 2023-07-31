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
        int ans=subsetSum(arr ,sum,N);
        return ans==1?true:false;
    }
    
     static int  subsetSum(int []nums ,int sum,int n){
        int[][]dp=new int [n+1][sum+1];
        for(int i=0;i<sum+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        
       
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j>=nums[i-1]){
                    if(dp[i-1][j-nums[i-1]]==0&&dp[i-1][j]==0)
                    dp[i][j]=0;
                    else dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    }
}