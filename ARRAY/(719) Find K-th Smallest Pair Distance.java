class Solution {
    
    //binary search
    public int smallestDistancePair(int[] nums, int k) {
      Arrays.sort(nums);
        int lo=0;
        for(int i=0;i<nums.length-1;i++){
            lo =Math.min(lo,nums[i+1]-nums[i]);
        }
        
        int hi =nums[nums.length-1]-nums[0];
        
        while(lo<hi){
            int mid =lo+(hi-lo)/2;
            int j=0;
            int actual=0;
            for(int i=0;i<nums.length;i++){
                while(j<nums.length && nums[j]-nums[i]<=mid){
                    j++;
                }
                actual +=j-i-1;
                
            }
            if(actual<k){
                lo =mid+1;
            }else{
                hi=mid;
            }
            
            
            
        }
        return lo;
        
    }
}