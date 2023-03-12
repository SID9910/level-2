 
 class Solution{
 //printing longest increasing subsequence
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
  int[] hash = new int[nums.length];
   for (int i=0;i<dp.length;i++){
       dp[i]=1;
   }
   int maxi =1; //khud ho sakta hai
  int lastindex =0;
  
   for(int index=0;index<nums.length;index++){
       hash[index]=index;
       for(int prev=0;prev<index;prev++){
           if(nums[prev]<nums[index] && 1+dp[prev] >dp[index]){
               dp[index]=1+dp[prev];
               hash[index]=prev;
           }
       }
       if(dp[index]>maxi){
           maxi =dp[index];
           lastindex=index;
       }
       
   }
  ArrayList<Integer> list = new ArrayList<>();
  list.add(nums[lastindex]);
  while(hash[lastindex]!=lastindex){
      lastindex =hash[lastindex];
      list.add(nums[lastindex]);
  }
  Collections.reverse(list);
  System.out.print(list);
  
      
   return maxi;
}
 }