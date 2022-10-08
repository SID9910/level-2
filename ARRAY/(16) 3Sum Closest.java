class Solution {
    //imp
    //brute force 
    //tc=o(n3)
    //space-o(1)
    //tle
//     public int threeSumClosest(int[] nums, int target) {
//        int ans = 0;
//         int diff = Integer.MAX_VALUE;
        
//         for(int i=0; i<nums.length-2; i++){
//             for(int j=i+1; j<nums.length-1; j++){
//                 for(int k=j+1; k<nums.length; k++){
                
//                     int currSum = nums[i] + nums[j] + nums[k];

//                     if(Math.abs(target-currSum) < diff){
//                         diff = Math.abs(target-currSum);
//                         ans = currSum;
//                     }
//                 }
//             }
//         }
        
//         return ans;
//     }
    
    //optimised 
    //tc =o(n2)
    //space=o(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
    int diff =Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int left =i+1;
            int right =nums.length-1;
            while(left <right){
                int temp =nums[i]+nums[left]+nums[right];
                if(Math.abs(target-temp)<diff){
                    diff =Math.abs(target-temp);
                    ans =temp;  
                }
                if(temp>target){
                    right--;
                }else if(temp<target){
                    left++;
                }else{
                    return temp;
                }
                
            }
        }
        return ans;
    }
}

























