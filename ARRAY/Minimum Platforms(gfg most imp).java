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


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count =0;
        int max =0;
        int i=0;
        int j=0;
        while(i<arr.length && j<dep.length){
        //aagr depart time jada hua mtlb train arrive hai  bss count karo and i++ karo agli train ko check
        //karne ke ley
        //ki or platform lagenge koi or train aai to
        //and else main train ja chuki hai kyuki dept time kum hai so j++
        //karo and count gta do mtlb or platform nhi lagenge
            if(arr[i]<=dep[j]){
                   i++;
                count++;
            }else{
             
                j++;
                count--;
            }
            max =Math.max(max,count);//isme minimum platform honge jha train rukki hogi
        }
        return max;
        
    }
    
}

