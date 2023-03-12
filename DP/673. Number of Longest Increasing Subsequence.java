class Solution {
    public int findNumberOfLIS(int[] nums) {
         int[] dp = new int[nums.length];
          for(int i=0;i<dp.length;i++){
              dp[i]=1;
              
          }
        int[] count = new int[nums.length];
              for(int i=0;i<dp.length;i++){
              count[i]=1;
              
          }  
        int maxi =1; //khud ho sakta hai
          for(int index=0;index<nums.length;index++){
              for(int prev=0;prev<index;prev++){
                  if(nums[prev]<nums[index] && 1+dp[prev]>dp[index]){
                      dp[index]=1+dp[prev];
                      count[index]=count[prev];
                      
                  }else if(nums[prev]<nums[index] && 1+dp[prev]==dp[index]){
                     count[index]+=count[prev]; 
                  }
              }
              maxi =Math.max(maxi ,dp[index]);
              
          }
             
        int nos =0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==maxi){
                nos+=count[i];
            }
        }
          return nos;
  
    }
}