class Solution {
    //recursion hai
//     public int minDistance(String word1, String word2) {
    
//       int mincount=edit(word1.length()-1 ,word2.length()-1 ,word1,word2);  
//       return mincount;  
//     }
//     public int edit(int index1 ,int index2 ,String s ,String t){
//         if(index1<0){
//             return index2+1;
//         }
//         if(index2<0){
//             return index1+1;
//         }
        
//         if(s.charAt(index1)==t.charAt(index2)){
//             return 0+edit(index1-1 ,index2-1 ,s,t);
//         }else{
//             return Math.min(1+edit(index1 ,index2-1 ,s,t),Math.min(1+edit(index1-1 ,index2 ,s,t),1+edit(index1-1 ,index2-1 ,s,t)));
            
//         }
        
//     }
    
    //memoization
//      public int minDistance(String word1, String word2) {
//     int[][] dp = new int[word1.length()][word2.length()];
//          for(int i=0;i<dp.length;i++){
//              for(int j=0;j<dp[0].length;j++){
//                  dp[i][j]=-1;
//              }
//          }
//       int mincount=edit(word1.length()-1 ,word2.length()-1 ,word1,word2 ,dp);  
//       return mincount;  
//     }
//     public int edit(int index1 ,int index2 ,String s ,String t,int[][] dp){
//         if(index1<0){
//             return index2+1;
//         }
//         if(index2<0){
//             return index1+1;
//         }
//         if(dp[index1][index2]!=-1){
//             return dp[index1][index2];
//         }
        
//         if(s.charAt(index1)==t.charAt(index2)){
//             return dp[index1][index2]= 0+edit(index1-1 ,index2-1 ,s,t,dp);
//         }else{
//             return dp[index1][index2]= Math.min(1+edit(index1 ,index2-1 ,s,t,dp),Math.min(1+edit(index1-1 ,index2 ,s,t,dp),1+edit(index1-1 ,index2-1 ,s,t,dp)));
            
//         }
        
//     }
    
    //tabulation
     public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length()+1][word2.length()+1];
 int n =word1.length();
         int m =word2.length();
         for(int i=0;i<=n;i++){
             dp[i][0]=i;
         }
         for(int j=0;j<=m;j++){
             dp[0][j]=j;
         }
         for(int index1=1;index1<=n;index1++){
             for(int index2=1;index2<=m;index2++){
               if(word1.charAt(index1-1)==word2.charAt(index2-1)){
            dp[index1][index2]= 0+dp[index1-1][index2-1];
        }else{
         dp[index1][index2]= Math.min(1+dp[index1][index2-1],Math.min(1+dp[index1-1][index2],1+dp[index1-1][index2-1]));  
             }
         }
    }
         return dp[n][m];
}
}