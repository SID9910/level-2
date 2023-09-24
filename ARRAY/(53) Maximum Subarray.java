class Solution {
    //brute force
    
    // public int maxSubArray(int[] nums){
    // int max =Integer.MIN_VALUE;
    // for(int i=0;i<nums.length;i++){
    //  for(int j=i;j<nums.length;j++){
    //      int sum=0;
    //      for(int k=i;k<=j;k++){
    //          sum+=nums[k];
    //          max =Math.max(max ,sum);
    //      }
    //  }   
    // }
    //     return max;
    // }
    
    //better 
//     public int maxSubArray(int[] nums){
//     int max =Integer.MIN_VALUE;
//     for(int i=0;i<nums.length;i++){
//         int sum=0;
//         for(int j=i;j<nums.length;j++){
        
         
//              sum+=nums[j];
//              max =Math.max(max ,sum);
//          }
//      }
//         return max;
//     }
        
    
    //optimised
    
    //kadanes algorithm very imp
    public int maxSubArray(int[] nums) {
     
        int res =Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>res){
                res =sum;
            }
            
            if(sum<0){
                sum=0;
            }
        }
        return res;
}
   
    //kadane's ke throug print bhi kar sakte hai
    //aagr maximum subarray print ke ley boll dea taab ye karna
//     public int maxSubArray(int[] nums) {
     
//         int res =Integer.MIN_VALUE;
//         int sum=0;
//         int start =-1;
//         int ansstart =-1;
//         int end =-1;
//         for(int i=0;i<nums.length;i++){
        
//             if(sum==0){
//                 start =i;
//             }
//             sum+=nums[i];
        
//             if(sum>res){
//                 res =sum;
//                 ansstart =start;
//                 end =i;
//             }
            
//             if(sum<0){
//                 sum=0;
//             }
//         }
//         for(int i=ansstart ;i<=end;i++){
//             System.out.print(nums[i]);
//         }
//         return res;
// }
}