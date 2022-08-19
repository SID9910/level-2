class Solution {
    
    public void rotate(int[] nums, int k) {
       
       int n = nums.length;
      k=k%n;
        if(k<0){
           k = k+n;
       }
       reverse(nums, 0, n-k-1);
       reverse(nums, n-k, n-1);
       reverse(nums, 0, n-1);
   }
   private void reverse(int[] nums, int left, int right){
       while(left<=right){
           swap(nums, left, right);
           left++;
           right--;
       }
   }
   private void swap(int[] nums, int left, int right){
       int temp = nums[left];
       nums[left] = nums[right];
       nums[right] = temp;
   }
 

  }
 