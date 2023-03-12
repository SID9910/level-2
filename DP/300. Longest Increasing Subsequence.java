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
//        public int lengthOfLIS(int[] nums) {
//            int[][] dp = new int[nums.length][nums.length+1];
//       int length=longest(0 ,-1 ,nums ,dp);
//         return length;
//     }
//     public int longest(int index ,int prev_index ,int[] nums,int[][] dp){
        
//         if(index ==nums.length){
//             return 0;
//         }
//         if(dp[index][prev_index+1]!=0){
//             return dp[index][prev_index+1];
//         }
//         //not take
//         int len =0+longest(index+1 ,prev_index , nums,dp);
//         if(prev_index==-1 || nums[index]>nums[prev_index]){
//             //take
//             len =Math.max(len ,1+longest(index+1 ,index , nums,dp));
//         }
//         return dp[index][prev_index+1] = len;
//     }
    
    //tabulation
//            public int lengthOfLIS(int[] nums) {
//            int[][] dp = new int[nums.length+1][nums.length+1];
//                int n=nums.length;
//                for(int index =n-1;index>=0;index--){
//                    for(int prev_index=index-1;prev_index>=-1;prev_index--){
//                      int len =0+dp[index+1][prev_index+1];
//         if(prev_index==-1 || nums[index]>nums[prev_index]){
//             //take
//             len =Math.max(len ,1+dp[index+1][index+1]);
//         }
                       
//                        dp[index][prev_index+1] = len;
//                    }
//                }
//                return  dp[0][-1+1];

//     }
    
    //more optimised tabulation
      public int lengthOfLIS(int[] nums) {
           int[] dp = new int[nums.length];
          for(int i=0;i<dp.length;i++){
              dp[i]=1;
          }
          int maxi =1; //khud ho sakta hai
          for(int index=0;index<nums.length;index++){
              for(int prev=0;prev<index;prev++){
                  if(nums[prev]<nums[index]){
                      dp[index]=Math.max(1+dp[prev],dp[index]);
                  }
              }
              maxi =Math.max(maxi ,dp[index]);
              
          }
             
          return maxi;
    }


}
