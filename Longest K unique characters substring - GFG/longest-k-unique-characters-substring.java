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
    public int longestkSubstr(String s, int k) {
        int i=0; // starting of window
        int j=0; // index to maintain window size
        int max_size=0;
        Map<Character,Integer>map=new HashMap<>(); //Map to input 
        while(j<s.length()) {
            // check if the character is there or not 
            char ch=s.charAt(j);
            
            if(map.get(ch)==null){
                map.put(ch,1); 
            }
            else{
                int val=map.get(ch);
                map.put(ch,val+1);
            }
            //  System.out.println("maxsize"+map.size());
            if(map.size()<k) j++;
            else{
                // System.out.println("Hii");
                if(map.size()==k){
                    max_size=Math.max(j-i+1,max_size);
                    j++;
                }
                else if(map.size()>k){
                    while(map.size()>k){
                        char c=s.charAt(i);
                        int val=map.get(c);
                        if(val==1) map.remove(c);
                        else map.put(c,val-1);
                        i++;
                    }
                    max_size=Math.max(j-i+1,max_size);
                    j++;
                }
                
            }
            
        }
        if(max_size==0) return -1;
        return max_size;
        
    }
}