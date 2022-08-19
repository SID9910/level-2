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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
      String result ="";
      int minlength=Integer.MAX_VALUE;
      //minimum length aajegi taaki .pta chale jada se jada itna common aaega
      for(int i=0;i<arr.length;i++){
          if(arr[i].length()<minlength){
              minlength =arr[i].length();
          }
      }
      
      for(int i=0;i<minlength;i++){
          char ch = arr[0].charAt(i);
          int flag=0;
          for(int j=1;j<n;j++){
              if(arr[j].charAt(i) !=ch){
                  flag=1;
                  break;
                  
              }
          }
          if(flag==0){
              result+=ch;
          }else{
              break;
          }
      }
      if(result.length()==0){
          return "-1";
      }else{
         return result; 
      }
      
    }
}

 