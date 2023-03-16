class Solution {
    //recursion se 
//     public int fn(int i, int j ){
//         if(i<0 || j<0 ){
//             return 0;
//         }
    
//         if(i==0 && j==0){
//             return 1;
//         }
//         int up =fn(i,j-1);
//         int down =fn(i-1,j);
//         return up+down;
//     }
    
//     public int uniquePaths(int m, int n) {

//         return fn(m-1,n-1);
//     }

    //memoization
//     public int fn(int i, int j ,int[][] dp){
//         if(i<0 || j<0 ){
//             return 0;
//         }
//         if(dp[i][j]!=0){
//             return dp[i][j];
//         }
//         if(i==0 && j==0){
//             return 1;
//         }
//         int up =fn(i,j-1,dp);
//         int down =fn(i-1,j,dp);
//         return dp[i][j]=up+down;
//     }
    
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         return fn(m-1,n-1,dp);
//     }
    
    //tabulation
     public int fn(int m, int n ,int[][] dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i ==0 && j==0) dp[i][j]=1;
                else {
                    int up=0;
                    int left=0;
                    if(i>0){
                         up =dp[i-1][j];
                    }
                    if(j>0){
                         left =dp[i][j-1];
                    }
                    dp[i][j] = up+left;
                }
                
            }
        }



        return dp[m-1][n-1];
        
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return fn(m,n,dp);
    }

}