class Solution {
    //rober 2
    public int rob(int[] nums) {
       ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int n =nums.length;
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                list1.add(nums[i]);
            }
            if(i!=n-1){
                list2.add(nums[i]);
            }
        }
        return Math.max(helper(list1),helper(list2));
    }
    
     public int helper(ArrayList<Integer> house){
           int n =house.size();
       int prev =house.get(0);
       int prev2 =0;
       for(int i=1;i<n;i++){
           int take =house.get(i);
           if(i>1)take+=prev2;
           int nontake =0+prev;
           int curri =Math.max(take,nontake);
           prev2 =prev;
           prev=curri;
       }
       return prev; 
     }
    
}


    
   
    