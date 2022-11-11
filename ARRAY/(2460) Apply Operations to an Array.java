class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
               nums[i]=2*nums[i];
               nums[i+1]=0;
            }
        }
       
         for(int i =0,j=0;i<nums.length;i++){
            if(nums[i]!=0){
                
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                System.out.println(nums[i]);
                j++;
            }
        }
        
        return nums;
      
}
}