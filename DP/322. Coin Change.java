class Solution {
    
    //recursion
//     public int minimumcoins(int index ,int[] coins ,int amount){
//         if(index==0){
//             if(amount%coins[0]==0){
//                 return amount/coins[index];
//             }else{
//                 return Integer.MAX_VALUE;
//             }
//         }
//         int nottake =0+minimumcoins(index-1 ,coins ,amount);
//         int take =Integer.MAX_VALUE;
//         if(coins[index]<=amount){
//             take =1+minimumcoins(index ,coins ,amount-coins[index]);
//         }
//         return Math.min(take,nottake);
        
//     }
    
//     public int coinChange(int[] coins, int amount) {
//     int ans  =minimumcoins(coins.length-1 ,coins ,amount);
//          if(ans>=Integer.MAX_VALUE)
//             return -1;
//         return ans;   
//     }
    
    //memoization
//         public int minimumcoins(int index ,int[] coins ,int amount,int[][] dp){
//         if(index==0){
//             if(amount%coins[0]==0){
//                 return amount/coins[index];
//             }else{
//                 return (int)1e8;
//             }
//         }
//             if(dp[index][amount]!=0){
//                 return dp[index][amount];
//             }
//         int nottake =0+minimumcoins(index-1 ,coins ,amount,dp);
//         int take =1e8;
//         if(coins[index]<=amount){
//             take =1+minimumcoins(index ,coins ,amount-coins[index],dp);
//         }
//         return dp[index][amount]= Math.min(take,nottake);
        
//     }
    
//     public int coinChange(int[] coins, int amount) {
//         int[][] dp = new int[coins.length][amount+1];
//     int ans  =minimumcoins(coins.length-1 ,coins ,amount,dp);
//          if(ans>=1e8)
//             return -1;
//         return ans;   
//     }
    
    //tabulation

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
      int n=coins.length;


    for(int i=0;i<=amount;i++)
    {
        if(i%coins[0]==0) dp[0][i]=i/coins[0];
        else dp[0][i]=(int)1e8;
    }

    for(int i=1;i<n;i++)
    {
        for(int j=0;j<=amount;j++)
        {
            int nt=0+dp[i-1][j];

            int take=(int)1e8;
            if(coins[i]<=j) take=1+dp[i][j-coins[i]];

            dp[i][j]=Math.min(take,nt);
        }
    }
    if(dp[n-1][amount]>=1e8) return -1; else return  dp[n-1][amount];

    }
}