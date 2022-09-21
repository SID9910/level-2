class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int lowestsumallowed =Integer.MIN_VALUE;
        int highestsumallowed =0;
        for(int num:weights){
            highestsumallowed+=num;
            lowestsumallowed =Math.max(lowestsumallowed,num);
        }
        while(lowestsumallowed<highestsumallowed){
            int mid =(lowestsumallowed+highestsumallowed)/2;
            int currentsum =0;
            int partition =1;
            for(int num:weights){
                if(currentsum+num<=mid){
                    currentsum+=num;
                    
                }else{
                    currentsum=num;
                    partition++;
                }
            }
            if(partition>days){
                lowestsumallowed=mid+1;
            }else{
                highestsumallowed =mid;
            }
        }
        
        return lowestsumallowed;
        
        
    }
}