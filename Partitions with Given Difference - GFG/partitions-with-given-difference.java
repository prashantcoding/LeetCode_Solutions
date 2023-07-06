//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int d, int arr[]){
         int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return isSum_top_down(arr,sum,n,d);
    }
    
     int isSum_top_down(int []arr,int sum,int n,int d) {
        int [][]dp=new int[n+1][sum+1];

        for(int i=0;i<sum+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-arr[i-1]]+dp[i-1][j])%1000000007;
                }else{
                    dp[i][j]=dp[i-1][j]%1000000007;
                }
            }
        }


        int []last_row=dp[n];
        int count=0;
        for(int i=sum/2;i<sum+1;i++){
            int diff=2*i-sum;
            if(last_row[i]!=0&&diff==d){
                count+=last_row[i];

            }
        }
        return count%1000000007;
    }
}