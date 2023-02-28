class Solution {
    //recursion
//          public int solve(List<List<Integer>> triangle,int i,int j){
//         if(i==triangle.size()-1) return triangle.get(triangle.size()-1).get(j);

// int down=triangle.get(i).get(j)+solve(triangle,i+1,j);
// int diag=triangle.get(i).get(j)+solve(triangle,i+1,j+1);
// return Math.min(down,diag);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
        
//         return solve(triangle,0,0);
//     }
    
//memoization
//      public int solve(List<List<Integer>> triangle,int i,int j,int[][] dp){
//         if(i==triangle.size()-1) return triangle.get(triangle.size()-1).get(j);
// if(dp[i][j]!=-1) return dp[i][j];
// int down=triangle.get(i).get(j)+solve(triangle,i+1,j,dp);
// int diag=triangle.get(i).get(j)+solve(triangle,i+1,j+1,dp);
// return dp[i][j]=Math.min(down,diag);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[][] dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
//         for(int[]row:dp) Arrays.fill(row,-1);
//        return solve(triangle,0,0,dp);
//     }
    
    //tabulation
 
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp= new int[triangle.get(triangle.size()-1).size()][triangle.get(triangle.size()-1).size()];
        for(int i=triangle.size()-1; i>=0; i--){
            for(int j=triangle.get(i).size()-1; j>=0; j--){
                if(i== triangle.size()-1) dp[i][j]= triangle.get(i).get(j);
                else{
                    int down= triangle.get(i).get(j) + dp[i+1][j];
                    int dia= triangle.get(i).get(j) + dp[i+1][j+1];
                    dp[i][j]= Math.min(down, dia);
                }
            }
        }
        return dp[0][0];
}
 
}