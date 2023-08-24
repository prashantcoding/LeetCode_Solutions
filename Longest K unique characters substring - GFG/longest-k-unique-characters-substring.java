//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String S, int K) {
         
       int i=0;
       int j=0;
       int n=S.length();
        Map<Character,Integer>hmap=new HashMap<>();
       int maxLen=-1;
       while(j<n){
           char ch=S.charAt(j);
           if(hmap.containsKey(ch)){
               hmap.put(ch,hmap.get(ch)+1);
           }
           else hmap.put(ch,1);
           if(hmap.size()<K){

               j++;
           }
           else{
              if(hmap.size()==K) maxLen=Math.max(maxLen,j-i+1);
              else{
                  char temp=S.charAt(i);
                  if(hmap.containsKey(temp)){
                      int val=hmap.get(temp);
                      if(val==1) hmap.remove(temp);
                      else hmap.put(temp,val-1);
                  }
                  i++;

              }
               j++;
           }
       }
        return maxLen;   
    }
}