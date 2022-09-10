class Solution {
    //tc-nlog(n)
    public int smallestDivisor(int[] nums, int threshold) {
    int lo=1;//divisor 1 se karenge
        int hi =Integer.MIN_VALUE;//isme max hoga divisor jha taak last kar sakte hai
        for(int val:nums){
            hi=Math.max(hi,val);
        }
        //nlogn
        while(lo<hi){
            int mid =(lo+hi)/2;//logn
            int sum=0;
            //n
            for(int val:nums){
                int quo =(val+mid-1)/mid;
                sum+=quo;
            }
            if(sum>threshold){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;//isme lo jha rukega vo divisor he hoga
    }
}