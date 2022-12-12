class Solution {
    public int climbStairs(int n) {
      int[] strg = new int[n+1];
        
       strg[0] = 1;
        for(int i=0;i<=n;i++){
            if(i-1>=0){
                strg[i]+=strg[i-1];
            }
            if(i-2>=0){
                strg[i]+=strg[i-2];
            }
        }
        return strg[n];
        
    }
}

//memoization
class Solution {
    public int climb(int n, int[] dp){
        if(n==0){

            return 1;

        }

        if(n<0){

            return 0;

        }
        if(dp[n]!=0){
            return dp[n];
        }

        int step1=climb(n-1,dp);

        int step2=climb(n-2,dp);

        return dp[n]=step1+step2;
        
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        int ans =climb(n,dp);
        return dp[n];
    }
}