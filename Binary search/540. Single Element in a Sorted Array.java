class Solution {
  
    public int singleNonDuplicate(int[] nums) {
      int lo=0;
        int hi=nums.length-1;
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[hi]!=nums[hi-1]){
            return nums[hi];
        }
        while(lo<=hi){
            int mid =(lo+hi)/2;
            
            
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]==nums[mid-1]){
               int left =mid-lo+1;
                if(left%2==0){
                    lo=mid+1;
                }else{
                    hi=mid-2;
                }
            }else if(nums[mid]==nums[mid+1]){
                int right=hi-mid+1;
                if(right%2==0){
                    hi=mid-1;
                }else{
                    lo=mid+2;
                }
            }
            
        }
        return lo;
        
            
        }
}