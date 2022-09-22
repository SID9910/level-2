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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
    long low =Long.MIN_VALUE;
    long high =0;
    for(int arrs:arr){
        high+=arrs;
        low =Math.max(low,arrs);
        
    }
    while(low<high){
        long actutaltime =(low+high)/2;
        int currenttime =0;
        int paintersrequired =1;//aaagr eek banda kare to
        for(int arrs:arr){
            if(currenttime+arrs<=actutaltime){
                currenttime+=arrs;
            }else{
                currenttime=arrs;
                paintersrequired++;
            }
        }
        if(paintersrequired>k){
            low =actutaltime+1;
        }else{
            high =actutaltime;
        }
    }
return low;    
    
    }
}


