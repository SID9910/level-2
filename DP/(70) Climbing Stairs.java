class Solution {
    //recursion hai
    
    // public int climbStairs(int n) {
    //     if(n==0){
    //         return 1;
    //     }
    //     if(n==1){
    //         return 1;
    //     }
    //     int left =climbStairs(n-1);
    //     int right =climbStairs(n-2);
    //     return left+right;
    // }
    
    //memoization
//     public int climb(int index,int[] dp){
//         if(index==0 || index==1){
//             return 1;
//         }
//         if(dp[index]!=0){
//             return dp[index];
//             }
//         int left =climb(index-1,dp);
//         int right =climb(index-2,dp);
//         return dp[index]=left+right;
        
        
//     }
    
//     public int climbStairs(int n){
//         int[] dp = new int[n+1];
//         int ans =climb(n ,dp);
//         return ans;
        
        
//     }
    
    //tabulation
//       public int climb(int index,int[] dp){
//         dp[0]=1;
//           dp[1]=1;
        
//         for(int i=2;i<=index;i++){
//             dp[i]=dp[i-1]+dp[i-2];
//         }
//           return dp[index];
        
//     }
    
//     public int climbStairs(int n){
//         int[] dp = new int[n+1];
//         int ans =climb(n ,dp);
//         return ans;
        
        
//     }
      
    //space optimisation
    public int climbStairs(int n){
        
        int prev=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int curr =prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
        
        
    }
    
}