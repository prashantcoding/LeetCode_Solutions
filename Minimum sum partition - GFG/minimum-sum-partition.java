//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

 
	
	public int minDifference(int arr[],int n) {
       
        int range=0;
        for(int x:arr){
            range+=x;
        }
        
        return subsetSum(arr,n,range);

    }
    int  subsetSum(int[]arr,int n,int range){
        boolean [][]t=new boolean[n+1][range+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<range+1;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
                if(i==0&&j==0){
                    t[i][j]=true;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<range+1;j++ ){
                if(j>=arr[i-1]){
                  t[i][j]=t[i-1][j]||t[i-1][j-arr[i-1]];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        boolean []temp=t[t.length-1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=range/2;i++){
            if(temp[i]==true){
                min=Integer.min(min,range-(2*i));
            }
        }
        return min;
    }
}
