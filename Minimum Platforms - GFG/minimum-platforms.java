//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends

class Train{
    int start;
    int end;
    Train(int start, int end){
        this.start=start;
        this.end=end;
    }
}
class SortTrain implements Comparator<Train>{
    public int compare(Train o1,Train o2){
            if(o1.start<o2.start){
                return -1;
            }
            
            else return 1;
    }
    
}
//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int at[], int dt[], int n)
    {
        if(at.length==1)return 1;
        if(at.length==0) return 0;
        ArrayList<Train>ar=new ArrayList<>();
        for(int i=0;i<at.length;i++){
            ar.add(new Train(at[i],dt[i]));

        }
        SortTrain obj=new SortTrain();
        Collections.sort(ar,obj);
        
        int limit=ar.get(0).end;
        ArrayList<Integer>occupy=new ArrayList<>();
        occupy.add(ar.get(0).end);
       
        for(int i=1;i<ar.size();i++){
            int k=needed(occupy,ar.get(i).start);
            if(k!=-1){
                
                occupy.set(k,ar.get(i).end);
            }
            else{
                
                occupy.add(ar.get(i).end);
            }

        }
        return occupy.size();
        
    }
     static int needed(ArrayList<Integer> occupy,int dep){
       
        for(int i=0;i<occupy.size();i++){
            if(occupy.get(i)<dep){
                return i;
            }
           
        }
        
         return -1;
    }
    
}

