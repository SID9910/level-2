//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   
    
     static long[] merge2sort(long[] left ,long[] right){
        
        long[] res = new long[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                res[k]=left[i];
                i++;
                k++;
            }else{

                //jaab left bada hoga to uske aage ke saare baade honge right se 
                //to uske aage ke inversion honge
                count+=(left.length-i); //bss issse se aajanege count
            res[k]=right[j];
                j++;
                k++;
            }
        }
        while(i<left.length){
            res[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            res[k]=right[j];
            j++;
            k++;
        }
        return res;
        
        
    }
    public  static long[] mergesort(long[] arr , int lo , int high){
          if(lo==high){
              long[] base = new long[1];
              base[0]=arr[lo];
              return base;
          }
         int mid =(lo+high)/2;
         
        long[] left =mergesort(arr, lo,mid);
         long[] right =mergesort(arr, mid+1,high);
         long[] merge22sort =merge2sort(left, right);
         
         return merge22sort;
         
         
     }
    
     static long count=0;
    static long inversionCount(long arr[], long N)
    {     count=0;
         mergesort(arr,0,arr.length-1);
         return count;
    }
}