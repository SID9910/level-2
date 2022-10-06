class Solution {
    //brute force tc=o(n2)
 //     public boolean containsDuplicate(int[] nums) {
 // for(int i=0;i<nums.length-1;i++){
 //             for(int j=i+1;j<nums.length;j++){
 //                 if(nums[i]==nums[j]){
 //                     return true;
 //                 }
 //             }
 //         }
 //         return false;
 //     }
     //tc=nlogn
       // public boolean containsDuplicate(int[] nums) {
       // Arrays.sort(nums);
       // for(int i=0; i<nums.length-1;i++)
       // {
       // if(nums[i]==nums[i+1]) return true;
       // }
       // return false;
       // }
     //optimised
      public boolean containsDuplicate(int[] nums) {
         Set<Integer> distinct = new HashSet<Integer>();
         for(int num : nums) {
             if(distinct.contains(num)) {
                 return true;
             }
             distinct.add(num);
         }
         return false;
     }
 }