class Solution {
  //recursion(tle)
//      public int robber(int index ,int[] arr ){
      
//         if(index==0){
//             return arr[index];
          
//         }
//         if(index<0){
//             return 0;
//         }
  
//         int pick =arr[index]+robber(index-2, arr);
  
//             int notpick =0+robber(index-1,arr);
//         return Math.max(pick,notpick);
//     }
//     public int rob(int[] nums) {
    
//         int ans = robber(nums.length-1,nums); 
//         return ans;
//     }
  
  //memoization(tle)
       public int robber(int index ,int[] arr ,int[] dp ){
      
      if(index==0){
          return arr[index];
          
      }
      if(index<0){
          return 0;
      }
  if(dp[index]!=0){
      return dp[index];
  }
           int pick =Integer.MIN_VALUE;
           if(index-2>=0){
   pick =arr[index]+robber(index-2, arr,dp);
           }         
          int notpick =0+robber(index-1,arr,dp);
      return dp[index]= Math.max(pick,notpick);
  }
  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
      int ans = robber(nums.length-1,nums ,dp); 
      return ans;
  }
  
  //tabulation
//          public int robber(int index ,int[] arr ,int[] dp ){
      
//         dp[0] =arr[0];
              
//         for(int i=1;i<arr.length;i++){
//             int take =arr[i];
//             if(i>1){
//                 take+=dp[i-2];
//             }
//             int nottake =0+dp[i-1];
//             dp[i]=Math.max(take ,nottake);
//         }
//              return dp[arr.length-1];
  
 
//     }
//     public int rob(int[] nums) {
//       int[] dp = new int[nums.length];
//         int ans = robber(nums.length-1,nums ,dp); 
//         return ans;
//     }
  
 //space optimisation

//     public int rob(int[] nums) {
//       int prev=nums[0];
//         int prev2=0;
//         for(int i=1;i<nums.length;i++){
//             int take =nums[i];
//             if(i>1){
//                 take+=prev2;
//             }
//             int nontake =0+prev;
//             int curr=Math.max(take,nontake);
//             prev2=prev;
//             prev=curr;
         
//         }
//          return prev;
//     }
}