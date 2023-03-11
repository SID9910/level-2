class Solution {
    //recursion
//     public int maxProfit(int[] prices) {
//         int profit =maxi(0,prices ,1,prices.length);
//         return profit;
//     }
//     public int maxi(int index ,int[] prices ,int buy ,int n){
//         if(index==n){
//             return 0;
//         }
//         int profit =0;
//         if(buy==1){
//             profit =Math.max(-prices[index]+maxi(index+1 ,prices ,0 , n) ,0+maxi( index+1 ,prices ,1 ,n));
//         }else{
            
//             profit =Math.max(prices[index]+maxi( index+1 ,prices ,1 , n) ,0+maxi( index+1 ,prices ,0,n));
            
//         }
//         return profit;
//     }
    
    //memoization
//     public int maxProfit(int[] prices) {
//         int[][] dp = new int[prices.length][2];
//         for(int i=0;i<dp.length;i++){
//             for(int j=0;j<dp[0].length;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         int profit =maxi(0,prices ,1,prices.length,dp);
//         return profit;
//     }
//     public int maxi(int index ,int[] prices ,int buy ,int n,int[][] dp){
//         if(index==n){
//             return 0;
//         }
//         if(dp[index][buy]!=-1){
//             return dp[index][buy];
//         }
//         int profit =0;
//         if(buy==1){
//             profit =Math.max(-prices[index]+maxi(index+1 ,prices ,0 , n,dp) ,0+maxi( index+1 ,prices ,1 ,n,dp));
//         }else{
            
//             profit =Math.max(prices[index]+maxi( index+1 ,prices ,1 , n,dp) ,0+maxi( index+1 ,prices ,0,n,dp));
            
//         }
//         return dp[index][buy]= profit;
//     }
    
    
    //tabulation
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int[][] dp = new int[n+1][2];
       dp[n][0]=0;
        dp[n][1]=0;
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
              int profit =0;
        if(buy==1){
            profit =Math.max(-prices[index]+dp[index+1][0] ,0+dp[index+1][1]);
        }else{
            
            profit =Math.max(prices[index]+dp[index+1][1] ,0+dp[index+1][0]);
            
        }
    dp[index][buy]= profit;   
            }
        }
        return dp[0][1];
    }
  
}