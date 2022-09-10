class Solution {
    //logn tc
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int mid =(lo+hi)/2;
            //increasing order main then means low left side main hai
            if(nums[mid]<nums[hi]){
                hi=mid;
            }else{
                //mid bda hai then right side main hoga
                lo=mid+1;
            }
        }
        return nums[lo];//isme lo hoga
    }
}