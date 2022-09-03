class Solution {
    //level-1 dp minimum cost in maze path similar
    public int minPathSum(int[][] grid) {
     int[][] dp = new int[grid.length][grid[0].length];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1 ;j>=0;j--){
                //last index
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=grid[i][j];
                }//last row
                else if(i==dp.length-1){
                    dp[i][j] =dp[i][j+1]+grid[i][j];
                }//last column
                else if(j==dp[0].length-1){
                    dp[i][j]=dp[i+1][j]+grid[i][j];
                }//bich ke saare
                else{
                    dp[i][j]= Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}