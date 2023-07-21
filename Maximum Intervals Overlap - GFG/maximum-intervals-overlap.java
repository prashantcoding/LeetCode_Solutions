//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] entry=new int[n];
			for(int i=0;i<n;i++)
				entry[i]=sc.nextInt();
			int[] exit=new int[n];
			for(int i=0;i<n;i++)
				exit[i]=sc.nextInt();
			Solution ob= new Solution();
			int[] res=ob.findMaxGuests(entry,exit,n);
			for(int i=0;i<2;i++){
				System.out.print(res[i]);
			    System.out.print(" ");
			}
			System.out.println();
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        return maxGuest(Entry,Exit);
	}
	 int []maxGuest(int[]arrive,int []exit){
        Arrays.sort(arrive);
        Arrays.sort(exit);
        int n=arrive.length;
        int m=exit.length;
        int[]guest=new int[Math.max(arrive[n-1],exit[m-1])+1];
        Arrays.fill(guest,0);
        int guest_in=1;
        int max_guest=1;
        int time=arrive[0];
        int i=1;
        int j=0;
        
        while(i<n && j<n){
            if(arrive[i]<=exit[j]){
                guest_in++;
            
            if(guest_in>max_guest){
                max_guest=guest_in;
                time=arrive[i];
            }
            i++;
            }else{
                guest_in--;
                j++;
            }
        }
        
       
        return new int[]{max_guest,time};
    }
}