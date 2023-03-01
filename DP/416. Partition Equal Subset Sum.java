class Solution {
    //memoization 
 //     public boolean subsetsumk(int index ,int target ,int[] nums,Boolean[][] dp){
 //         if(target==0){
 //             return true;
 //         }
 //         if(index==0){
 //             return nums[0]==target;
 //         }
 
 //         if(dp[index][target]!=null){
 //             return dp[index][target];
 //         }
 //         boolean nottake =subsetsumk(index-1 ,target ,nums ,dp);
 //         boolean take =false;
 //         if(target>=nums[index]){
 //             take =subsetsumk(index-1 ,target-nums[index] ,nums ,dp);
 //         }
 //         return dp[index][target]=(take || nottake);
 //     }
     
 //     public boolean canPartition(int[] nums) {
 //         int totalsum =0;
 //         for(int i=0;i<nums.length;i++){
 //             totalsum+=nums[i];
 //         }
 //         if(totalsum%2==1){
 //             return false;
 //         }
 //                 int target =totalsum/2;
 //         Boolean[][] dp = new Boolean[nums.length][target+1];
 
 //         return subsetsumk(nums.length-1 ,target ,nums ,dp);
 //     }
     
     
     //tabulation
     public boolean canPartition(int[] nums) {
         int totalsum =0;
         for(int i=0;i<nums.length;i++){
             totalsum+=nums[i];
         }
         if(totalsum%2==1){
             return false;
         }
                 int target =totalsum/2;
         boolean[][] dp = new boolean[nums.length][target+1];
         
         
         for(int i=0;i<nums.length;i++){
             dp[i][0]=true;
         }
         if(nums[0]<=target){
             dp[0][nums[0]]=true;
         }
         
         for(int i=1;i<nums.length;i++){
             for(int j =1;j<=target;j++){
                boolean nottake =dp[i-1][j];
         boolean take =false;
         if(j>=nums[i]){
             take =dp[i-1][j-nums[i]];
         }
         dp[i][j]=(take || nottake);  
             }
         }
        
 
         return dp[nums.length-1 ][target];
     }
    
 }