//{ Driver Code Starts
//Initial Template for Java

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
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        return LCS_TOPDOWN(S1,S2,n,m);
    }
     int LCS_TOPDOWN(String X,String Y,int n,int m){
        if(n==0||m==0) return 0;

        int [][]dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0;
                }
            }
        }

       
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++)
            mx=Math.max(mx,dp[i][j]);
        }
        return mx;
    }
}