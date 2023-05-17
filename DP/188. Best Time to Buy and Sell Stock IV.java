class Solution {
    //recursion hai
//         public int maxProfit(int k ,int[] prices) {
//             int profit =maxi(0,prices ,1,prices.length ,k);
//             return profit;
//         }
//         public int maxi(int index ,int[] prices ,int buy ,int n,int transaction){
//             if(index==n){
//                 return 0;
//             }
//             if(transaction==0){
//                 return 0;
//             }
//             int profit =0;
//             if(buy==1){
//                 profit =Math.max(-prices[index]+maxi(index+1 ,prices ,0 , n,transaction) ,0+maxi( index+1 ,prices ,1 ,n,transaction));
//             }else{
        
//                 profit =Math.max(prices[index]+maxi( index+1 ,prices ,1 , n,transaction-1) ,0+maxi( index+1 ,prices ,0,n,transaction));
        
//             }
//             return profit;
//         }

//memoization
//         public int maxProfit(int k,int[] prices) {
//             int[][][] dp = new int[prices.length][2][k+1];

//             int profit =maxi(0,prices ,1,prices.length,dp,k);
//             return profit;
//         }
//         public int maxi(int index ,int[] prices ,int buy ,int n,int[][][] dp,int transaction){
//             if(index==n){
//                 return 0;
//             }
//         if(transaction==0){
//             return 0;
//         }
//             if(dp[index][buy][transaction]!=0){
//                 return dp[index][buy][transaction];
//             }
//             int profit =0;
//             if(buy==1){
//                 profit =Math.max(-prices[index]+maxi(index+1 ,prices ,0 , n,dp,transaction) ,0+maxi( index+1 ,prices ,1 ,n,dp,transaction));
//             }else{
        
//                 profit =Math.max(prices[index]+maxi( index+1 ,prices ,1 , n,dp,transaction-1) ,0+maxi( index+1 ,prices ,0,n,dp,transaction));
        
//             }
//             return dp[index][buy][transaction]= profit;
//         }


//tabulation
public int maxProfit(int k ,int[] prices) {
    int n =prices.length;
    int[][][] dp = new int[n+1][2][k+1];

    
    //first base case
    for(int i=0;i<=n;i++){
        for(int buy =0;buy<=1;buy++){
            dp[i][buy][0]=0;
        }
    }
    //second base case
    for(int buy=0;buy<=1;buy++){
        for(int c=0;c<=k;c++){
            dp[n][buy][c]=0;
        }
    }
    
    
    for(int index=n-1;index>=0;index--){
        for(int buy=0;buy<=1;buy++){
        for(int cap=1;cap<=k;cap++){
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
    return dp[0][1][k];
    }
        
}
