class pair{
    int element;
    int numMin;
    pair(int element , int numMin){
        this.element =element;
        this.numMin =numMin;
    }
}
class Solution {
     public long m =(long)Math.pow(10,9)+7;
    public int sumSubarrayMins(int[] arr) {
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];
        ArrayDeque<pair> stack1 = new ArrayDeque<>();
        ArrayDeque<pair> stack2 = new ArrayDeque<>();
        
        //filling our left array
        for(int i=0;i<arr.length;i++){
            int curr_ele =arr[i];
            int count =1;
            while(stack1.size()!=0 && stack1.peek().element >curr_ele){
                count+=stack1.peek().numMin;
                stack1.pop();
            }
            stack1.push(new pair(curr_ele ,count));
            left[i] =count;
        }

        
        //filling our right array
        for(int i=arr.length-1 ;i>=0;i--){
            int curr_ele =arr[i];
            int count =1;
            while(stack2.size()!=0 && stack2.peek().element >=curr_ele){
                count+=stack2.peek().numMin;
                stack2.pop();
            }
            stack2.push(new pair(curr_ele ,count));
            right[i] =count;
        }
        long ans =0;
        for(int i=0;i<arr.length;i++){
            ans =(ans+left[i]*right[i]*arr[i])%m;
        }
        return (int)ans;
    }
}