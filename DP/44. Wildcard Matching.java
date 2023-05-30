class Solution {
    //recursion hai
//     public boolean isMatch(String s, String p) {
//         boolean predict =wildcard( s.length()-1, p.length()-1 ,s , p); 
//         return predict;
//     }
//     public boolean wildcard(int index1 ,int index2 ,String s ,String p){
//        if(index1<0 && index2<0){
//            return true;
//        }
//         if(index1>=0 && index2<0){
//             return false;
//         }
//         if(index2>=0 && index1<0){
//             for(int i=0;i<=index2;i++){
//                 if(p.charAt(i)!='*'){
//                     return false;
//                 }
//             }
//             return true;
//         }
        
        
//       if(s.charAt(index1)==p.charAt(index2)||p.charAt(index2)=='?'){
//         return wildcard( index1-1 , index2-1 ,s , p);
//     }
//         if(p.charAt(index2)=='*'){
//             return wildcard( index1-1 , index2 ,s , p) || wildcard( index1 , index2-1 ,s , p);
//         }
        
//         return false;
//     }
    
    //memoization --tle
   // public   boolean solve(int ind1,int ind2,String s,String p,boolean[][] dp){
   //      if(ind1<0 && ind2<0) return true;
   //      if(ind2<0) return false;
   //      if(ind1<0){
   //          for(int i=0;i<=ind2;i++){
   //              if(p.charAt(i)!='*') return false;
   //          }
   //          return true;
   //      }
   //      if(dp[ind1][ind2]!=false) return dp[ind1][ind2];
   //      if(s.charAt(ind1)==p.charAt(ind2) || p.charAt(ind2)=='?') return dp[ind1][ind2]=solve(ind1-1,ind2-1,s,p,dp);
   //      else if(p.charAt(ind2)=='*'){
   //          return dp[ind1][ind2]=solve(ind1-1,ind2,s,p,dp) || solve(ind1,ind2-1,s,p,dp);
   //      }
   //      return dp[ind1][ind2]=false;
   //  }
   //  public boolean isMatch(String s, String p) {
   //      int n=s.length();
   //      int m=p.length();
   //        boolean[][] dp = new boolean[s.length()][p.length()];
   //      return solve(n-1,m-1,s,p,dp);
   //  }
    
    //tabulation
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
           dp[i][0]=false;

        }
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1)=='*')
                dp[0][j]=true;
            else
                break;
        }
       
           
                
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                 
            
                 if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    dp[i][j]=dp[i-1][j-1];
                 else if(p.charAt(j-1)=='*'){

                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else
                    dp[i][j]=false;
                   
            }
        }
        return dp[n][m];
    }
    
}