class Solution {
    //recursion
    
//     public int minCut(String s) {
//      int minimum =cuts( 0 ,s)-1;
//         return minimum;
//     }
    
//     public boolean ispalindrome(int i ,int  j,String s){
//         while(i<j){
//             if(s.charAt(i)!=s.charAt(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
    
    
//     public int cuts(int i ,String s){
//         if(i==s.length()){
//             return 0;
//         }
//         int mincost =Integer.MAX_VALUE;
        
//         for(int j =i;j<s.length();j++){
            
//         if(ispalindrome(i,j,s)==true){
//             int cost =1+cuts(j+1,s);
//             mincost =Math.min(mincost ,cost);
//         }
        
        
//         }
//         return mincost;
        
//     }
    
    //memoization
//       public int minCut(String s) {
//           int[] dp  = new int[s.length()];
//           for(int i=0;i<dp.length;i++){
//               dp[i]=-1;
//           }
//      int minimum =cuts( 0 ,s,dp)-1;
//         return minimum;
//     }
    
//     public boolean ispalindrome(int i ,int  j,String s){
//         while(i<j){
//             if(s.charAt(i)!=s.charAt(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
    
    
//     public int cuts(int i ,String s,int[] dp){
//         if(i==s.length()){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int mincost =Integer.MAX_VALUE;
        
//         for(int j =i;j<s.length();j++){
            
//         if(ispalindrome(i,j,s)==true){
//             int cost =1+cuts(j+1,s,dp);
//             mincost =Math.min(mincost ,cost);
//         }
        
        
//         }
//         return dp[i]=mincost;
        
//     }
    
    //tabulation
          public int minCut(String s) {
          int[] dp  = new int[s.length()+1];
             int n  =s.length();
              dp[n]=0;
              for(int i=n-1;i>=0;i--){
                  int mincost =Integer.MAX_VALUE;
        
        for(int j =i;j<s.length();j++){
            
        if(ispalindrome(i,j,s)==true){
            int cost =1+dp[j+1];
            mincost =Math.min(mincost ,cost);
        }
        
        
        }
        dp[i]=mincost;  
              }
     return  dp[0]-1;
    
    }
    
    public boolean ispalindrome(int i ,int  j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}
    
  
      
 