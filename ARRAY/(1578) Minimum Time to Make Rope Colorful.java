class Solution {
    
    //dp ke baad dubara aaonga ispe
    // tc =o(n)
       public int minCost(String s,int[] neededTime) {
        int n = s.length();
        int result = 0;
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                result = result + Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }
        return result;
    }
}
   