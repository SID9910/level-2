class Solution {
    //recursion
//     public int longestPalindromeSubseq(String s) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(s);
// 		return f(s.length()-1,s.length()-1,s, sb.reverse().toString());
//     }
    
    
//     private int f(int ind1, int ind2, String txt1, String txt2) {
//         // Base Case
//         if (ind1 < 0 || ind2 < 0) {
//             return 0;
//         }
        
//         // if match
//         if (txt1.charAt(ind1) == txt2.charAt(ind2)) {
//             return 1 + f(ind1 - 1, ind2 - 1, txt1, txt2);
//         }
        
//         // if not match
//         return Math.max(f(ind1 - 1, ind2, txt1, txt2), f(ind1, ind2 - 1, txt1, txt2));
//     }

//memoization
    
   
//     public int longestPalindromeSubseq(String s) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(s);
// 		return getLengthOfLCS(s, sb.reverse().toString());
//     }
    
//     private int getLengthOfLCS(String  text1, String  text2) {
//         int l1 = text1.length(), l2 = text2.length();
        
//         int[][] dp = new int[l1][l2];
//         for (int[] row: dp) {
//             Arrays.fill(row, -1);
//         }
        
//         return f(l1 - 1, l2 - 1, text1, text2, dp);
//     }
    
//     private int f(int ind1, int ind2, String txt1, String txt2, int[][] dp) {
//         // Base Case
//         if (ind1 < 0 || ind2 < 0) {
//             return 0;
//         }
        
//         if (dp[ind1][ind2] != -1) {
//             return dp[ind1][ind2];
//         }
        
//         // if match
//         if (txt1.charAt(ind1) == txt2.charAt(ind2)) {
//             return dp[ind1][ind2] = 1 + f(ind1 - 1, ind2 - 1, txt1, txt2, dp);
//         }
        
//         // if not match
//         return dp[ind1][ind2] = Math.max(f(ind1 - 1, ind2, txt1, txt2, dp), f(ind1, ind2 - 1, txt1, txt2, dp));
//     }
    
    //tabulation
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
		return getLengthOfLCS(s, sb.reverse().toString());
    }
    
    private int getLengthOfLCS(String  text1, String  text2) {
        int l1 = text1.length(), l2 = text2.length();
        
        int[][] dp = new int[l1 + 1][l2 + 1];
        
        // Base Case
        // shifting index by 1
        for (int ind2 = 0; ind2 <= l2; ind2++) {
            dp[0][ind2] = 0;
        }
        
        for (int ind1 = 0; ind1 <= l1; ind1++) {
            dp[ind1][0] = 0;
        }
        
        
        for (int ind1 = 1; ind1 <= l1; ind1++) {
            for (int ind2 = 1; ind2 <= l2; ind2++) {
                
                // If match
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }   
        
                // if not match
                else   dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        
        return dp[l1][l2];
    }
}


