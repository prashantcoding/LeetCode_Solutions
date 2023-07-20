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
            String[] inp=read.readLine().split(" ");
            Long X=Long.parseLong(inp[0]);
            Long Y=Long.parseLong(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.isPowerOfAnother(X,Y));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static Long isPowerOfAnother(Long x, Long y){
        if(x==1 && y==1 ) return 1L;
        if(x==1 && y==0)  return 1L;
        if(x==1 )return 0L;
        if(y==1) return 1L;
        if(y<x) return 0L;
        if(x==y) return 1L;
        long count=0;
       while(y>x){
           long temp=y/x;
           
           if(temp%x!=0) return 0L;
           y=temp;
          
       }
       return 1L;
        
    }
}
