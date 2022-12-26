class Solution {
    //recursive approach
        //   public boolean canJump(int[] nums) {
        //     return canjump(nums,0);
        // }
        // public boolean canjump(int num[],int ind){
        //     if(ind>num.length) return false;
        //     if(ind==num.length-1) return true;
        //     for(int i=1;i<=num[ind];i++){
        //         if(canjump(num,ind+i)){
        //             return true; 
        //         }
        //     }
        //     return false;
        // }
        
        public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
        
    }