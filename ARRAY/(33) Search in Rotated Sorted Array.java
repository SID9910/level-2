class Solution {
    //logn
    //asked in many product based company
    //pehle lo nikalo use se pta chla jaega kitna roteted hain ye
    public int search(int[] nums, int target) {
        int lo =0;
        int hi =nums.length-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<nums[hi]){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        int rotated=lo;//isme rotated ka index hoga
        //left half
        int s1 =binarysearch(nums,0,rotated-1,target);
        if(s1!=-1){
            return s1;
        }
        //right half
        int s2 =binarysearch(nums,rotated,nums.length-1,target);
       
        return s2;
       
    }
    //normal binary search
    public int binarysearch(int[] arr, int lo , int hi ,int val){
        while(lo<=hi){
            int mid =lo+(hi-lo)/2;
            if(val>arr[mid]){
                lo=mid+1;
            }else if(val<arr[mid]){
                hi=mid-1;
                
            }else{
                return mid;
            }
            
        }
        return -1;
    }
}