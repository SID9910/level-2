class Solution {
    //tc =0(n) and space =0(1)
    public boolean increasingTriplet(int[] nums) {
      int left =Integer.MAX_VALUE;
        int right =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            //check for first value means i
            if(nums[i]<left){
                left =nums[i];
                
                //check for middle means j right value
            }else if(nums[i]>left && nums[i]<right){
                right =nums[i];
            }else if(nums[i]>right){ //last vale check right se agli means 
                                    //k value
                return true;
            }
        }
        return false;
         
        
    }
}