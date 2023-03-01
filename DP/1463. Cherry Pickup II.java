class Solution {
    //recursion
//     public int pickup(int j1, int i ,int j2 ,int[][] grid){
//         if(j1<0 || j2>=grid[0].length || j2<0 || j1>=grid[0].length){
//             return -999;
//         }
//         if(i==grid.length-1){
//             if(j1==j2){
//                 return grid[i][j1];
//             }else{
//                 return grid[i][j1]+grid[i][j2];
//             }
//         }
//         int maxi =0;
//         for(int dj1=-1 ;dj1<=1;dj1++){
//             for(int dj2=-1;dj2<=1;dj2++){
//                 if(j1==j2){
//                     maxi =Math.max(grid[i][j1]+pickup(j1+dj1 ,i+1 ,j2+dj2 ,grid) ,maxi);
//                 }else{
//                     maxi =Math.max(maxi ,grid[i][j1]+grid[i][j2]+pickup(j1+dj1 ,i+1 ,j2+dj2,grid));
//                 }
//             }
//         }
//         return maxi;
        
        
        
//     }
    
//     public int cherryPickup(int[][] grid) {
//        int m =grid.length;
//         int n =grid[0].length;
//         int ans  =pickup(0,0,n-1 ,grid);
//         return ans;
        
//     }
    
    //memoization
//     public int pickup(int j1, int i ,int j2 ,int[][] grid ,int[][][] dp){
//         if(j1<0 || j2>=grid[0].length || j2<0 || j1>=grid[0].length){
//             return -1000001;
//         }
//         if(i==grid.length-1){
//             if(j1==j2){
//                 return grid[i][j1];
//             }else{
//                 return grid[i][j1]+grid[i][j2];
//             }
//         }
//         if(dp[i][j1][j2]!=-1){
//             return dp[i][j1][j2];
//         }
//         int maxi =-1000001;
//         for(int dj1=-1 ;dj1<=1;dj1++){
//             for(int dj2=-1;dj2<=1;dj2++){
//                 if(j1==j2){
//                     maxi =Math.max(grid[i][j1]+pickup(j1+dj1 ,i+1 ,j2+dj2 ,grid,dp) ,maxi);
//                 }else{
//                     maxi =Math.max(maxi ,grid[i][j1]+grid[i][j2]+pickup(j1+dj1 ,i+1 ,j2+dj2,grid,dp));
//                 }
//             }
//         }
//         return dp[i][j1][j2] =maxi;
        
        
        
//     }
    
//     public int cherryPickup(int[][] grid) {
//        int m =grid.length;
//         int n =grid[0].length;
//         int[][][] dp  = new int[m][n][n];
//      for(int i=0;i<m;i++) //filling the 3d dp array to -1
// 	{
// 	    for(int j=0;j<n;j++)
// 	    {
// 	        for(int k=0;k<n;k++)
// 	        {
// 	            dp[i][j][k] = -1;
// 	        }
// 	    }
// 	}
	
//         int ans  =pickup(0,0,n-1 ,grid ,dp);
//         return ans;
        
//     }
    
    //tabulation

     public int cherryPickup(int[][] grid) {
       int n= grid.length;
       int m= grid[0].length;
       
       int[][][] dp = new int[n][m][m];
      
        
       for(int j1=0;j1<m;j1++){
           for(int j2=0;j2<m;j2++){
               if(j1==j2){
                   dp[n-1][j1][j2]=grid[n-1][j1];
               }else{
                   dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
               }
           }
       } 
        
       for(int i=n-2;i>=0;i--){
           for(int j1=0; j1<m; j1++){
               for(int j2=0; j2<m; j2++){
                   
                   
        int maxi=(int)-1e8;
        for(int dj1=-1;dj1<=+1;dj1++){
            for(int dj2=-1;dj2<=+1;dj2++){
                int value=0;
                if(j1==j2){
                   value=grid[i][j1] ;
                }else{
                   value=grid[i][j1]+grid[i][j2];  
                }
                
                if(dj1+j1>=0 && dj1+j1<m && dj2+j2>=0 && dj2+j2<m){
                    value+=dp[i+1][dj1+j1][dj2+j2];
                }else{
                    value+=(int)-1e8;
                }
                maxi=Math.max(maxi,value);
            }
        }
        dp[i][j1][j2]=maxi; 
                   
                   
               }
           }
       } 
        
       return dp[0][0][m-1 ];
     }

}
                    