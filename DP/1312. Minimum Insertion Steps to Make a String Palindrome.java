class Solution {
    //     public int minInsertions(String s) {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(s);
    //         int ans =palindrome(s.length()-1 ,s.length()-1 ,s,sb.reverse().toString());
            
    //         return s.length()-ans;
    //     }
        
    //     public int palindrome(int index1 ,int index2 ,String s1 ,String s2){
            
    //         if(index1<0 || index2<0){
    //             return 0;
                
    //         }
    //         if(s1.charAt(index1)==s2.charAt(index2)){
    //             return 1+palindrome(index1-1 ,index2-1 ,s1 ,s2);
                
    //         }
    //         return 0+Math.max(palindrome(index1-1 ,index2 ,s1 ,s2),palindrome(index1,index2-1 ,s1,s2));
    //     }
        
        //memoization
    //     public int minInsertions(String s) {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(s);
    //         int[][] dp = new int[s.length()][s.length()];
    //          for (int i=0;i<dp.length;i++){
    //              for(int j=0;j<dp[0].length;j++){
    //                  dp[i][j]=-1;
    //              }
    //          }
    //         int ans =palindrome(s.length()-1 ,s.length()-1 ,s,sb.reverse().toString() ,dp);
            
    //         return s.length()-ans;
    //     }
        
    //     public  int palindrome(int index1 ,int index2 ,String s1 ,String s2 ,int[][] dp){
            
    //         if(index1<0 || index2<0){
    //             return 0;
                
    //         }
    //         if(dp[index1][index2]!=-1){
    //             return dp[index1][index2];
    //         }
    //         if(s1.charAt(index1)==s2.charAt(index2)){
    //             return dp[index1][index2]=1+palindrome(index1-1 ,index2-1 ,s1 ,s2,dp);
                
    //         }
    //         return dp[index1][index2] = 0+Math.max(palindrome(index1-1 ,index2 ,s1 ,s2,dp),palindrome(index1,index2-1 ,s1,s2,dp));
    //     }
        
        //tabulation
         public int minInsertions(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            int[][] dp = new int[s.length()+1][s.length()+1];
             for (int i=0;i<dp.length;i++){
                 for(int j=0;j<dp[0].length;j++){
                     dp[i][j]=-1;
                 }
             }
            int ans =palindrome(s,sb.reverse().toString() ,dp);
            
            return s.length()-ans;
        }
        
        public  int palindrome(String s1 ,String s2 ,int[][] dp){
            
            
            for(int i=0;i<=s1.length();i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=s2.length();i++){
                dp[0][i]=0;
            }
            for(int i=1;i<=s1.length();i++){
                for(int j=1;j<=s2.length();j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
             dp[i][j]=1+dp[i-1 ][j-1];
                
            }else{
                        dp[i][j] = 0+Math.max(dp[i-1][j],dp[i][j-1]);
        
                    }  
                }
            }
          
            return dp[s1.length()][s2.length()]; 
            }
    }