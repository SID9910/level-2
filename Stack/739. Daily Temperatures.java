class Solution {
    //done aacha sawal h
        public int[] dailyTemperatures(int[] temperatures) {
     Stack<Integer> st = new Stack<>();
        int n =temperatures.length;
        int[] ans = new int[temperatures.length];
        
        for(int i=n-1;i>=0;i--){
            
            
         while(st.size()>0 && temperatures[i]>=temperatures[st.peek()]){
             st.pop();
         }            
            
            if(st.size()>0){
                ans[i]=st.peek()-i;
            }
            
            st.push(i);
            
            
            
            
        }
        return ans;
        
        
    }
}