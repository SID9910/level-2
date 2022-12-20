public class 931. Minimum Falling Path Sum {
    
}
class Solution {
    //tabulation
    public int minFallingPathSum(int[][] A) {
        int min=Integer.MAX_VALUE;
        int n=A.length; 
        int[][] dp =new int[n][n];
        
        for(int j = 0; j < n; j++){
             
            dp[0][j] = A[0][j];
         
         }
      for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int up = A[i][j] + dp[i - 1][j];
                int ld = 0;
                if(j - 1 >= 0)  ld = A[i][j] + dp[i - 1][j - 1];
                else    ld += Integer.MAX_VALUE;
                int rd = 0;
                if(j + 1 < n)   rd = A[i][j] + dp[i - 1][j + 1];
                else    rd += Integer.MAX_VALUE;
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
         
        for(int i = 0; i < A.length; i++)
        {
         min = Math.min(min,dp[A.length-1][i]);
        }
        return min;
    }
}