class Solution {
    public int maximumProduct(int[] nums) {
     int min1 = Integer.MAX_VALUE;//do minimum number manlo negative hue to ho sakta hai vo                                       baade ho
        int min2 =Integer.MAX_VALUE;
        
        int max1 =Integer.MIN_VALUE;
        int max2 =Integer.MIN_VALUE;
        int max3 =Integer.MIN_VALUE;

      for(int val:nums){
          if(val<=min1){
              min2 = min1;
              min1 =val;
          }else if(val<=min2){
              min2=val;
          }
          if(val>=max1){
              max3 =max2;
              max2= max1;
              max1= val;
          }else if(val>=max2){
              max3 =max2;
              max2=val;
              
          }else if(val>=max3){
              max3=val;
          }
      }
        return Math.max(min1*min2*max1 ,max3*max2*max1);
    }
}