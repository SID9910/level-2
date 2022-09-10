class Solution {
    //acquire aqnd release 
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int count=0;
        int res=0;
        while(i<nums.length){
            //jaab taak aay zero count badate jao
            //acquire karte jao
            if(nums[i]==0){
                count++;
            }
            //aagr count k se jada hua tabhi release karo j ki help se
            while(count>k){
                if(nums[j]==0){
                    count--;
                }
                j++;
            }
            
        int length=i-j+1;//particular subarray ki length check karte jao
            res =Math.max(res,length);//update karte jao aagr baadi mille to
            i++;
            
        }
        return res;//maximum subarray length
    }
}