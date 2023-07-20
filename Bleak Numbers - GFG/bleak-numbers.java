//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
       return isBleak(n)?1:0;
    }
    static boolean isBleak(int x){
        for(int i=1;i<x;i++){
            if(i+countSetBits(i)==x) return false;

        }
        return true;
    }
    static private int countSetBits(int i) {
        int count=0;

        while(i>0){
            count+=i&1;
            i>>=1;

        }
        return count;
    }
}