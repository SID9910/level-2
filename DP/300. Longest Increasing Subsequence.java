class Solution {
    //recursion
//     public int lengthOfLIS(int[] nums) {
//       int length=longest(0 ,-1 ,nums);
//         return length;
//     }
//     public int longest(int index ,int prev_index ,int[] nums){
        
//         if(index ==nums.length){
//             return 0;
//         }
//         //not take
//         int len =0+longest(index+1 ,prev_index , nums);
//         if(prev_index==-1 || nums[index]>nums[prev_index]){
//             //take
//             len =Math.max(len ,1+longest(index+1 ,index , nums));
//         }
//         return len;
//     }
 
    //memoization
       public int lengthOfLIS(int[] nums) {
           int[][] dp = new int[nums.length][nums.length+1];
      int length=longest(0 ,-1 ,nums ,dp);
        return length;
    }
    public int longest(int index ,int prev_index ,int[] nums,int[][] dp){
        
        if(index ==nums.length){
            return 0;
        }
        if(dp[index][prev_index+1]!=0){
            return dp[index][prev_index+1];
        }
        //not take
        int len =0+longest(index+1 ,prev_index , nums,dp);
        if(prev_index==-1 || nums[index]>nums[prev_index]){
            //take
            len =Math.max(len ,1+longest(index+1 ,index , nums,dp));
        }
        return dp[index][prev_index+1] = len;
    }

}
