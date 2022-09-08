//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        long mod = (long)Math.pow(10,9)+7;
        long[] dp0 =new long[n+1];
        long[] dp1 =new long[n+1];
        dp0[1]=1;
        dp1[1]=1;
        for(int i=2;i<=n;i++){
            dp0[i]=(dp1[i-1]+dp0[i-1])%mod;
            dp1[i]=dp0[i-1]%mod;
        }
        
        return (dp0[n]+dp1[n])%mod;
        }
}