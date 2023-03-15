class Solution {
    //recursion
 //     public int maxCoins(int[] nums) {
           
 //          List<Integer> list = new ArrayList<>();
 //          // add 0 in a list
 //          list.add(1);
 //          // add all the cuts element in list
 //          for (int i=0;i<nums.length;i++){
 //              list.add(nums[i]);
 //          } 
         
 //          list.add(1);
          
          
        
 //          return cutter(1,nums.length,list);
          
          
 //      }
      
      
      
 //      private int cutter(int i,int j,List<Integer> list){
 //          if (i>j){
 //              return 0;
 //          }
          
        
 //          int maxi = Integer.MIN_VALUE;
 //          for (int ind=i;ind<=j;ind++){
 //              int steps = list.get(i-1)*list.get(ind)*list.get(j+1)
 //                  + cutter(i,ind-1,list)   // for left side 
 //                  + cutter(ind+1,j,list);  // for right side
 //              maxi = Math.max(steps,maxi);
 //          }
 //         return maxi;
 //      }
     
     //memoization
 //     public int maxCoins(int[] nums) {
 //           int[][] dp = new int[nums.length+2][nums.length+2];
 //          List<Integer> list = new ArrayList<>();
 //          // add 0 in a list
 //          list.add(1);
 //          // add all the cuts element in list
 //          for (int i=0;i<nums.length;i++){
 //              list.add(nums[i]);
 //          } 
         
 //          list.add(1);
          
          
        
 //          return cutter(1,nums.length,list,dp);
          
          
 //      }
      
      
      
 //      private int cutter(int i,int j,List<Integer> list,int[][] dp){
 //          if (i>j){
 //              return 0;
 //          }
 //         if(dp[i][j]!=0){
 //             return dp[i][j];
 //         }
        
 //          int maxi = Integer.MIN_VALUE;
 //          for (int ind=i;ind<=j;ind++){
 //              int steps = list.get(i-1)*list.get(ind)*list.get(j+1)
 //                  + cutter(i,ind-1,list,dp)   // for left side 
 //                  + cutter(ind+1,j,list,dp);  // for right side
 //              maxi = Math.max(steps,maxi);
 //          }
 //         return dp[i][j]=maxi;
 //      }
     
     //tabulation
     
      public int maxCoins(int[] nums) {
     
      int[][] dp = new int[nums.length+2][nums.length+2];//kyuki we add 1and 1
            
          List<Integer> list = new ArrayList<>();
      
          list.add(1);
          
          for (int i=0;i<nums.length;i++){
              list.add(nums[i]);
          } 
         
          list.add(1);
          
          for (int i = nums.length; i >= 1; i--) {
              for (int j = 1; j <= nums.length; j++) {
                  if (i > j) continue;
                  
          int maxi = Integer.MIN_VALUE;
 
          
                  for (int ind = i; ind <= j; ind++) {
                      int cost = list.get(i-1)*list.get(ind)*list.get(j+1) + dp[i][ind - 1] + dp[ind + 1][j];
                       maxi = Math.max(cost,maxi);
                  }
  
                  dp[i][j] = maxi;
              }
          }
          
          return dp[1][nums.length];
      }
 
 }