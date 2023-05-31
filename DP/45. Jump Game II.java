class Solution {
    //greedy hai
     public int jump(int[] nums) {
       int curmax=0;
         int jumps=0;
         int curReach=0;
         for(int i=0;i<nums.length-1;i++){
             if(i+nums[i]>curmax){
                 curmax=nums[i]+i;
             }
             
 
             if(i==curReach){
                 jumps++;
                 curReach=curmax;
                 
             }
         }
         return jumps;
     }
 }