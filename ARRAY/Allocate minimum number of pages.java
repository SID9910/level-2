//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(A.length<M){
            return -1;
        }
        int low =Integer.MIN_VALUE;
        int high =0;
        for(int num:A){
            low =Math.max(low,num);
            high+=num;
            
        }
        while(low<high){
            int mid =(low+high)/2;
            
            int currentpages =0;
            int students =1;
            for(int num:A){
                if(currentpages+num<=mid){
                    currentpages+=num;
                }else{
                    currentpages=num;
                    students++;
                }
            }
            
            if(students>M){
                low=mid+1;
            }else{
                high=mid;
            }
            
            
        }
        return low;
        
    }
};