class Solution {

    //recursion
//       public int mincostTickets(int[] days, int[] costs) {
     
//         int cost =mincost(0,days ,costs);
//         return cost;
        
//     }
    
//     public static int mincost(int index ,int[] days,int[] costs){
       

        
//         if(index>=days.length){
//             return 0;
//         }
      
        
//         int day1 =costs[0]+mincost(index+1,days,costs);
//         int i;
//         for( i=index ;i<days.length && days[i]<days[index]+7;i++){
            
//         }
//         int day7 =costs[1]+mincost(i,days,costs); 
//       for( i=index ;i<days.length && days[i]<days[index]+30;i++){
   
//       }
//          int day30 =costs[2]+mincost(i,days,costs);
        
//         return Math.min(day1,Math.min(day7,day30));
        
//     }
    
    //memoization
//     public int mincostTickets(int[] days, int[] costs) {
//      int[] dp = new int[days.length+1];
//         for(int i=0;i<dp.length;i++){
//             dp[i]=-1;
//         }
//         int cost =mincost(0,days ,costs, dp);
//         return cost;
        
//     }
    
//     public static int mincost(int index ,int[] days,int[] costs,int[] dp){
       

        
//         if(index>=days.length){
//             return 0;
//         }
//         if(dp[index]!=-1){
//             return dp[index];
//         }
        
        
//         int day1 =costs[0]+mincost(index+1,days,costs,dp);
//         int i;
//         for( i=index ;i<days.length && days[i]<days[index]+7;i++){
            
//         }
//         int day7 =costs[1]+mincost(i,days,costs,dp); 
//       for( i=index ;i<days.length && days[i]<days[index]+30;i++){
   
//       }
//          int day30 =costs[2]+mincost(i,days,costs,dp);
        
//         return dp[index]= Math.min(day1,Math.min(day7,day30));
        
//     }
    
    
    //tabulation
          public int mincostTickets(int[] days, int[] costs) {
               int n=days.length; 
              
              int[] dp =new int[n+1];
             
              dp[n]=0;
        for(int k=n-1;k>=0;k--){
            int day1 =costs[0]+dp[k+1];
            int i;
        for( i=k ;i<days.length && days[i]<days[k]+7;i++){
            
        }
        int day7 =costs[1]+dp[i]; 
      for( i=k ;i<days.length && days[i]<days[k]+30;i++){
   
      }
         int day30 =costs[2]+dp[i];
        
     dp[k]= Math.min(day1,Math.min(day7,day30));  
            
            
        }
            
              return dp[0];
          }
    
    
}