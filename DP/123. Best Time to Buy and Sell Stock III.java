    class Solution {
        //recursion
    //     public int maxProfit(int[] prices) {
    //         int profit =maxi(0,prices ,1,prices.length ,2);
    //         return profit;
    //     }
    //     public int maxi(int index ,int[] prices ,int buy ,int n,int transaction){
    //         if(index==n){
    //             return 0;
    //         }
    //         if(transaction==0){
    //             return 0;
    //         }
    //         int profit =0;
    //         if(buy==1){
    //             profit =Math.max(-prices[index]+maxi(index+1 ,prices ,0 , n,transaction) ,0+maxi( index+1 ,prices ,1 ,n,transaction));
    //         }else{
            
    //             profit =Math.max(prices[index]+maxi( index+1 ,prices ,1 , n,transaction-1) ,0+maxi( index+1 ,prices ,0,n,transaction));
            
    //         }
    //         return profit;
    //     }
    
    //memoization
    //     public int maxProfit(int[] prices) {
    //         int[][][] dp = new int[prices.length][2][3];
    //         for(int i=0;i<dp.length;i++){
    //             for(int j=0;j<dp[0].length;j++){
    //                 for(int k=0;k<3;k++){
    //                  dp[i][j][k]=-1;   
    //                 }
                
    //             }
    //         }
    //         int profit =maxi(0,prices ,1,prices.length,dp,2);
    //         return profit;
    //     }
    //     public int maxi(int index ,int[] prices ,int buy ,int n,int[][][] dp,int transaction){
    //         if(index==n){
    //             return 0;
    //         }
    //     if(transaction==0){
    //         return 0;
    //     }
    //         if(dp[index][buy][transaction]!=-1){
    //             return dp[index][buy][transaction];
    //         }
    //         int profit =0;
    //         if(buy==1){
    //             profit =Math.max(-prices[index]+maxi(index+1 ,prices ,0 , n,dp,transaction) ,0+maxi( index+1 ,prices ,1 ,n,dp,transaction));
    //         }else{
            
    //             profit =Math.max(prices[index]+maxi( index+1 ,prices ,1 , n,dp,transaction-1) ,0+maxi( index+1 ,prices ,0,n,dp,transaction));
            
    //         }
    //         return dp[index][buy][transaction]= profit;
    //     }
    
    
    //tabulation
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int[][][] dp = new int[n+1][2][3];
    
        
        //first base case
        for(int i=0;i<=n;i++){
            for(int buy =0;buy<=1;buy++){
                dp[i][buy][0]=0;
            }
        }
        //second base case
        for(int buy=0;buy<=1;buy++){
            for(int c=0;c<=2;c++){
                dp[n][buy][c]=0;
            }
        }
        
        
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
            for(int cap=1;cap<=2;cap++){
                    int profit =0;
        if(buy==1){
            profit =Math.max(-prices[index]+dp[index+1][0][cap] ,0+dp[index+1][1][cap]);
        }else{
            
            profit =Math.max(prices[index]+dp[index+1][1][cap-1] ,0+dp[index+1][0][cap]);
            
        }
    dp[index][buy][cap]= profit;   
            
        }
        
            }
    }
        return dp[0][1][2];
        }
            
    }
