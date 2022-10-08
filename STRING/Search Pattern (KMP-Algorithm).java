//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //isme string matching karenge
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
    int[] lps =kmp(pat); //isme lps pada hai
     
     int j=0;
     int i=0;
     
     while(i<txt.length()){
        //aaabr baaraber bss index badao 
         if(txt.charAt(i)==pat.charAt(j)){
             i++;
             j++;
            //jaise he pattern vali khatam 
            //hui mtlb pattern pura hua 
            //to aab piche jakar or check karo
            if(j==pat.length()){
                res.add(i-j+1);//udher taak ka daal lo
                j=lps[j-1];//peche jakar check karega
            }
             
         }else{
             //txt and pattern bahar nhi hua taab ka kaam same 
             //kmp vala 
             if(j>0){
                 j=lps[j-1];
             }else{
                 i++; //bss aage bado
             }
         }
         }
         return res;
     }
    
    //basically kmp nikalo
    int[] kmp(String pat){
        int[] lps =new int[pat.length()];
        lps[0]=0;
        int i=1;
        int len=0;
        while(i<pat.length()){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len>0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}