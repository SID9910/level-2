class Solution {
    //recursion hai
//   public int minPathSum(int[][] arr) {
//         int m=arr.length;
//         int n=arr[0].length;
//         return f(m-1,n-1,arr);
//     }
//     public int f(int i,int j,int arr[][])
//     {
//         if(i==0 &&j==0) return arr[0][0];
//         if(i<0 ||j<0) return 999;
//         int up=arr[i][j]+f(i-1,j,arr);
//         int left= arr[i][j]+f(i,j-1,arr);
//         return Math.min(up,left);
//     }
    
    //memoization
  //   public int f(int i, int j,int[][] grid ,int[][] dp){
  //       if(i==0 && j==0) return grid[0][0];
  //       if(i<0 ||j<0) return 999;
  //     if(dp[i][j]!=0){
  //         return dp[i][j];
  //     }
  //       int up =  grid[i][j]+f(i-1, j, grid ,dp);
  //       int left =grid[i][j]+f(i, j-1, grid,dp);
  //       return dp[i][j]= Math.min(up, left);
  //   }
  // public  int minPathSum(int[][] grid) {
  //       int m = grid.length;
  //       int n = grid[0].length;
  //     int[][] dp = new int[m][n];
  //       return f(m-1, n-1, grid ,dp);
  //   }
    
    //tabulation
      public int f(int m, int n,int[][] arr ,int[][] dp){
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(i==0 && j==0){
                  dp[i][j]=arr[0][0];
              }else{
                 int up=0,left=0;
                    if(i>0) up=arr[i][j]+dp[i-1][j];
                    else  up=arr[i][j]+999;
                    if(j>0) left=arr[i][j]+dp[i][j-1];
                    else  left=arr[i][j]+999;
                    dp[i][j]=Math.min(up,left);
              }
              
          }
      }
          return dp[m-1][n-1];
    }
  public  int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
      int[][] dp = new int[m][n];
        return f(m, n, grid ,dp);
    }
    
}