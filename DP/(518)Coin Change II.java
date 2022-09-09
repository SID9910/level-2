class Solution {
    //coin change combination/dynamic programming
    public int change(int amount, int[] coins) {
       int[] dp =new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int target=1;target<=amount;target++){
                if(target>=coin){
                    dp[target]+=dp[target-coin];
                    
                }
            }
        }
        return dp[amount];
    }
}