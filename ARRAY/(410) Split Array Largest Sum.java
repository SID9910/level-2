class Solution {
    public int splitArray(int[] nums, int m) {
        int highestsumallowed =0;
        int lowestsumallowed =Integer.MIN_VALUE;
        for(int num:nums){
            highestsumallowed+=num;
            lowestsumallowed =Math.max(lowestsumallowed,num);
        }
        
        while(lowestsumallowed<highestsumallowed){
            
            //mid 
            int mid =(lowestsumallowed+highestsumallowed)/2;
            
            //current part ka sum lekar chlao
            int currpartsum=0;
            //partion lekar chalo
            int partition =1;//ye 1 to hoga ke pura array ka end
            for(int num:nums){
                if(currpartsum +num <=mid){
                    currpartsum +=num;
                }else{
                    //idher iss point per he partition hoga
                    currpartsum=num;
                    partition++;
                }
                
            }
            //aab given partiton kitna dea hai aaagr uske barabar to sahi
            //nahi to kya karo eek se bda do
            if(partition>m){
               lowestsumallowed =mid+1;    
            }else{
                highestsumallowed =mid;//ye range ko or chota kar rahe hai hum
            }
        }
        return lowestsumallowed;
    }
}