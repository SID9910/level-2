class Solution {
    //recursion
    // public  int subsequence(int index1 ,int index2 ,String t1 ,String t2){
    //     if(index1<0 || index2<0){
    //         return 0;
    //     }
    //     if(t1.charAt(index1)==t1.charAt(index2)){
    //         return 1+subsequence(index1-1 ,index2-1 ,t1,t2);
    //     }
    //         return Math.max(subsequence(index1 ,index2-1 ,t1,t2),subsequence(index1-1 ,index2 ,t1,t2));
    //     }
        
    
    
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int ans =subsequence(text2.length()-1 ,text1.length()-1 ,text1,text2);
    //      return ans;
    // }
    
    //memoization
   
//     public int longestCommonSubsequence(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
        
//         int[][] dp=new int[m][n];
//         for(int[] row: dp) Arrays.fill(row,-1);
        
//         return help(m-1,n-1,s1,s2,dp);
//     }
//     public int help(int ind1, int ind2, String s1, String s2, int[][] dp){
        
//         if(ind1<0 || ind2<0) return 0;
        
//         if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
//         // if char at ind1 & ind2 matches
//         if(s1.charAt(ind1) == s2.charAt(ind2))
//             return dp[ind1][ind2] = 1 + help(ind1-1, ind2-1, s1, s2, dp);
        
//         // if doesn't matches
//         return dp[ind1][ind2] = Math.max(help(ind1-1,ind2,s1,s2,dp), help(ind1,ind2-1,s1,s2, dp));        
//     }
    
    //tabulation
     
       public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp=new int[m+1][n+1];
  for(int i=0;i<m;i++){
               dp[i][0]=0;
           }
            for(int i=0;i<n;i++){
        dp[0][i]=0;
    }
         
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }    


}