//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getSmallest(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String getSmallest(Long N) {
    StringBuilder sb = new StringBuilder();
    
    //agr ye condition means vo he number hai
    if(N<10){
        return N+ "";
    }
    
    for(int div =9 ;div>1;div--){
        while(N%div ==0){
            N=N/div;//number kam karo
            sb.append(div);
        }
    }
    
    //aagr N 9 se bda hua means vo divide nhi hua or number bada hai
    //simple return -1
    if(N>=10){
        return "-1";
    }
    
    //reverse kar lena kyuli order utla hai
    return sb.reverse().toString();
    }
};