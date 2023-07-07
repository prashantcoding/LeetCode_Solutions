//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        return top_down(coins,N,sum);
    }
     long top_down(int []coin,int n,int sum){
        long [][]dp=new long[n+1][sum+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j>=coin[i-1]){
                    dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}