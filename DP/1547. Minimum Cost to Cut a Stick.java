class Solution {
    //recursion
 //     public int minCost(int n, int[] cuts) {
         
     
 //         List<Integer> list = new ArrayList<>();
 //         // add 0 in a list
 //         list.add(0);
 //         // add all the cuts element in list
 //         for (int i=0;i<cuts.length;i++){
 //             list.add(cuts[i]);
 //         } 
        
 //         list.add(n);
 //         Arrays.sort(cuts);
         
       
 //         return cutter(1,cuts.length,list);
         
         
 //     }
     
     
     
 //     private int cutter(int i,int j,List<Integer> list){
 //         if (i>j){
 //             return 0;
 //         }
         
       
 //         int mini = Integer.MAX_VALUE;
 //         for (int ind=i;ind<=j;ind++){
 //             int steps = list.get(j+1) - list.get(i-1) 
 //                 + cutter(i,ind-1,list)   // for left side 
 //                 + cutter(ind+1,j,list);  // for right side
 //             mini = Math.min(steps,mini);
 //         }
 //        return mini;
 //     }
     
     //memoization
 //         public int minCost(int n, int[] cuts) {
 //         Arrays.sort(cuts);
 //     int[][] dp = new int[cuts.length+2][cuts.length+2];//kyuki we add 0 and n
 //              for (int i=0;i<=cuts.length;i++) Arrays.fill(dp[i],-1);
 //         List<Integer> list = new ArrayList<>();
     
 //         list.add(0);
         
 //         for (int i=0;i<cuts.length;i++){
 //             list.add(cuts[i]);
 //         } 
        
 //         list.add(n);
         
         
       
 //         return cutter(1,cuts.length,list,dp);
         
         
 //     }
     
     
     
 //     private int cutter(int i,int j,List<Integer> list,int[][] dp){
 //         if (i>j){
 //             return 0;
 //         }
 //         if(dp[i][j]!=-1){
 //             return dp[i][j];
 //         }
         
       
 //         int mini = Integer.MAX_VALUE;
 //         for (int ind=i;ind<=j;ind++){
 //             int steps = list.get(j+1) - list.get(i-1) 
 //                 + cutter(i,ind-1,list,dp)   // for left side 
 //                 + cutter(ind+1,j,list,dp);  // for right side
 //             mini = Math.min(steps,mini);
 //         }
 //        return dp[i][j]= mini;
 //     }
     
     //tabulation
        public int minCost(int n, int[] cuts) {
         Arrays.sort(cuts);
     int[][] dp = new int[cuts.length+2][cuts.length+2];//kyuki we add 0 and n also
           
         List<Integer> list = new ArrayList<>();
     
         list.add(0);
         
         for (int i=0;i<cuts.length;i++){
             list.add(cuts[i]);
         } 
        
         list.add(n);
         
           
         for (int i = cuts.length; i >= 1; i--) {
             for (int j = 1; j <= cuts.length; j++) {
                 if (i > j) continue;
                 
                 int mini = Integer.MAX_VALUE;
         
                 for (int ind = i; ind <= j; ind++) {
                     int cost = list.get(j + 1) - list.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                     mini = Math.min(mini, cost);
                 }
 
                 dp[i][j] = mini;
             }
         }
         
         return dp[1][cuts.length];
     }
       
     
         
         
     }
     
     
    
     
 