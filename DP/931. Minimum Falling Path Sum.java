class Solution {
    //recursion
//     public int minFallingPathSum(int[][] matrix) {
//         int min=Integer.MAX_VALUE;
//         int n=matrix.length;
//         int m=matrix[0].length;
//         for(int i=0;i<m;i++){
//             int val=helper(matrix,n-1,i,m);
//             min=Math.min(min,val);
//         }
//         return min;
//     }
//     public int helper(int a[][],int i,int j,int m){  
//         if(j<0 || j>=m){
//             return (int)1e9;
//         }
//         if(i==0)
//         return a[0][j];

//         int up=a[i][j]+helper(a,i-1,j,m);
//         int ld=a[i][j]+helper(a,i-1,j-1,m);
//         int rd=a[i][j]+helper(a,i-1,j+1,m);
//         return Math.min(up,Math.min(ld,rd));
//     }
    
    //memoization
//     public int minFallingPathSum(int[][] matrix) {
//         int min=Integer.MAX_VALUE;
//         int n=matrix.length;
//         int m=matrix[0].length;
//         int[][] dp = new int[n][n];
//         for(int i=0;i<m;i++){
//             int val=helper(matrix,n-1,i,m,dp);
//             min=Math.min(min,val);
//         }
//         return min;
//     }
//     public int helper(int a[][],int i,int j,int m,int[][] dp){
//         if(j<0 || j>=m){
//             return (int)1e9;
//         }
//         if(i==0)
//         return a[0][j];

//         if(dp[i][j]!=0){
//             return dp[i][j];
//         }
//         int up=a[i][j]+helper(a,i-1,j,m,dp);
//         int ld=a[i][j]+helper(a,i-1,j-1,m,dp);
//         int rd=a[i][j]+helper(a,i-1,j+1,m,dp);
//         return dp[i][j]= Math.min(up,Math.min(ld,rd));
//     }
    
    //tabulation
         public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]= new int[n][m];

        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=Integer.MAX_VALUE,ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                up=matrix[i][j]+dp[i-1][j];
                if(j-1>=0) ld=matrix[i][j]+dp[i-1][j-1];
                if(j+1<m) rd=matrix[i][j]+dp[i-1][j+1];
                dp[i][j]=Math.min(up,Math.min(ld,rd));
            }
        }
             int min=dp[n-1][0];
        for(int i=1;i<m;i++){
            min=Math.min(dp[n-1][i],min);
        }
        return min;
    }
}