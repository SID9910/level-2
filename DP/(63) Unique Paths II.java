class Solution {
    //recursion
//     static int allpath(int i, int j, int[][] obstacleGrid){
//     if (i == 0 && j == 0) {
        
//         return 1;
//     }
//     if(i<0 || j<0 ||obstacleGrid[i][j]==1)return 0;

    
    
//     int up =   allpath(i-1, j, obstacleGrid);
//     int left =   allpath(i, j-1, obstacleGrid);
    
//     int count = up + left;
    
//     return count;
// } 
    
    
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
              
//         int m = obstacleGrid.length;
// int n = obstacleGrid[0].length;
        
//     return allpath(m-1, n-1, obstacleGrid);    
//     }
    
    //memoization
//     static int allpath(int i, int j, int[][] obstacleGrid, int[][] dp){
//     if (i == 0 && j == 0) {
        
//         return 1;
//     }
//     if(i<0 || j<0 ||obstacleGrid[i][j]==1)return 0;

//     if(dp[i][j]!=0) return dp[i][j];
    
//     int up =   allpath(i-1, j, obstacleGrid, dp);
//     int left =   allpath(i, j-1, obstacleGrid, dp);
    
//     int count = up + left;
    
//     return dp[i][j] = count;
// } 
    
    
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
//         int m = obstacleGrid.length;
// int n = obstacleGrid[0].length;

//     int[][] dp =  new int [m][n];
        
//     return allpath(m-1, n-1, obstacleGrid, dp);    
//     }
    
    //tabulation
        static int allpath(int m, int n, int[][] obstacleGrid, int[][] dp){

             for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else{
                    int left=0,up=0;
                    if(j-1>=0) left=dp[i][j-1];
                    if(i-1>=0) up=dp[i-1][j];
                    dp[i][j]=left+up;
                }
            }
        }
        return dp[m-1][n-1];
} 
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        int m = obstacleGrid.length;
int n = obstacleGrid[0].length;

    int[][] dp =  new int [m][n];
        
    return allpath(m, n, obstacleGrid, dp);    
    }
}
  
    
