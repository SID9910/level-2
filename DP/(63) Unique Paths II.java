class Solution {
    //memoization
    static int allpath(int i, int j, int[][] obstacleGrid, int[][] dp){
    if (i == 0 && j == 0) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        return 1;
    }
    if(i<0 || j<0)return 0;
    if(obstacleGrid[i][j]==1)return 0;

    if(dp[i][j]!=0) return dp[i][j];
    
    int up =   allpath(i-1, j, obstacleGrid, dp);
    int left =   allpath(i, j-1, obstacleGrid, dp);
    
    int count = up + left;
    
    return dp[i][j] = count;
} 
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        int m = obstacleGrid.length;
int n = obstacleGrid[0].length;

    int[][] dp =  new int [m][n];
        
    return allpath(m-1, n-1, obstacleGrid, dp);    
    }
}
  
    
