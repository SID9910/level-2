class Solution {
    public int minimumAverageDifference(int[] nums) {
      long sum=0;
      for(int i=0;i<nums.length;i++){
          sum+=nums[i];
      }  
      long prev =0;
      long ans=0;
      long min =Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
       
       long left =prev+nums[i];
          left/=(i+1);
          prev +=nums[i];
         long right =sum-nums[i];
        sum=sum-nums[i];
          if(i!=nums.length-1){
          right/=nums.length-i-1;
          }
           int res =(int)Math.abs(left-right);
 
         if(res<min){
             min=res;
             ans=i;
         }

    }
    return (int)ans;

    }
}