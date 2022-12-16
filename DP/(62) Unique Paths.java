class Solution {
    //memoization
    public int fn(int i, int j ,int[][] dp){
        if(i<0 || j<0 ){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(i==0 && j==0){
            return 1;
        }
        int up =fn(i,j-1,dp);
        int down =fn(i-1,j,dp);
        return dp[i][j]=up+down;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return fn(m-1,n-1,dp);
    }
}