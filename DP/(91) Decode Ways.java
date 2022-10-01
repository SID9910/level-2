class Solution {
    public int numDecodings(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i=2;i<dp.length;i++){
            char chi =s.charAt(i-1);//words eeek aage hai
            char chim =s.charAt(i-2);
            if(chi!='0'){
                dp[i]=dp[i-1];
            }
            if(chim!='0' && Integer.parseInt(""+ chim + chi)<=26){
                dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}