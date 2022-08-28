class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      
        //next greater element nikalo same pura
        //bss thoda change hai hum index dalte hai isme
        //stack main
        //and length daal do akri main
        //tc =0(n)
        int[] ngl = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums.length-1);
        ngl[nums.length-1]=nums.length; //ngl main hum sabke next greater ke index store karenge
        
        for(int i=nums.length-2;i>=0;i--){
            while(st.size()>0 && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ngl[i]=nums.length;
            }else{
                ngl[i]=st.peek();
            }
            st.push(i);
        }
        
        //logic main
        int[] res = new int[nums.length-k+1];//kyuki max k ka pehle he mill jaega
                                             //aage k taak ka nhi milega jha taak hai
        int j=0;
            for(int i=0;i<res.length;i++){
                //aaagr j kabhi piche chut gay i se taab ka kaam
             if(j<i){
                 j=i;
             }
                //particular isme he hoga kaam
                //basically ye window hai jisme hoga max
                //window se aage ka consider nhi karenge            
                while(ngl[j]<=i+k-1){
                j =ngl[j];
            }
                res[i]=nums[j];//isme index ki value daald denge
        }
        return res;
        
    }
}