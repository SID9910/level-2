public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
       //brute force approach
    //    int res=Integer.MIN_VALUE;
    //    for(int start =0;start<nums.length;start++){
    //        int count=0;
    //        for(int end =start;end<nums.length;end++){
    //            if(nums[end]==0){
    //                count++;
    //            }
    //            if(count<=1){
    //            res =Math.max(end-start+1,res);
    //            }
    //        }
    //    }
    //    return res;
       
      //optimised 
        //acquire and release strategy
        int i=0;
        int j=0;
        int count=0;
        int res =0;
        while(i<nums.length){
            if(nums[i]==0){
                count++;
            }
            while( count>1){
                if(nums[j]==0){
                    count--;

                }
                j++;
            }
            int len =i-j+1;
            res =Math.max(res,len);
            i++;
        }
        return res;
    }
}