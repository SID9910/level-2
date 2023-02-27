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
        
        //ye concept like last se uska last-1 compare or faith  karke
        //nikal rahe hai
        public boolean canJump(int[] nums) {
        int  n=nums.length-1;
            int lastposition=n;
            for(int i=n-1;i>=0;i--){
                if(i+nums[i]>=lastposition){
                    lastposition=i;
                }
            }
            return lastposition==0; //mtlb zero index per pohoch gya
    
    }
        
    }