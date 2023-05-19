class Solution {
    //yet 
    public boolean checkSubarraySum(int[] nums, int k) {
       // stores mod values of k mapped with first time found index hai
       HashMap<Integer,Integer> map = new HashMap<>();
       long sum=0;
       map.put(0,-1); // base case no sum at -1 position
       for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           int rem = (int)sum%k;
           if(map.containsKey(rem)){
               
               if(i-map.get(rem)>1)
                   return true;
           }
           else
               map.put(rem,i);
       }
       return false;
   }
}

