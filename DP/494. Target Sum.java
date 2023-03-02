class Solution {
    
    //memoization
    public int findTargetSumWays(int[] a, int target) {
        
        int totalSum = 0;
        for(int i: a) totalSum += i;
        
        if (totalSum-target < 0) return 0;
        if((totalSum-target)%2 == 1)  return 0;
        int n =a.length;
        int sum = ( totalSum-target)/2;
        int[][] dp=new int[n][sum+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        
        return f(n-1,sum,a,dp);
        
    }
    public int f(int i, int sum, int[] a, int[][] dp){
        
        if(i == 0){
            if(sum == 0 && a[i] == 0) return 2;
            if(sum == 0 || a[i] == sum) return 1;
            return 0;
        }
        if(dp[i][sum] != -1) return dp[i][sum];
        int notPick = f(i-1,sum,a,dp);
        int pick = 0;
        if(sum>=a[i]){
            pick = f(i-1,sum-a[i],a,dp);
        }
        return dp[i][sum] = pick + notPick;
    }
}

     
    
  
        
      