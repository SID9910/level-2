class Solution {
    public int climbStairs(int n) {
      int[] strg = new int[n+1];
        
       strg[0] = 1;
        for(int i=0;i<=n;i++){
            if(i-1>=0){
                strg[i]+=strg[i-1];
            }
            if(i-2>=0){
                strg[i]+=strg[i-2];
            }
        }
        return strg[n];
        
    }
}