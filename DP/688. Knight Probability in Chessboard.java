class Solution {
    
    //tle
    //recursion
//     public double knightProbability(int n, int k, int row, int column) {
      
//         int[][] moves ={ {-2,-1},{-2,1},{-1,-2},{-1,2},{2,1},{1,-2},{1,2},{2,-1}};  
        
//         double nj =sol(n,k,row ,column ,moves);
//         return nj;
//     }
    
    
//     public double sol(int n ,int k ,int row ,int col,int[][] moves){
        
//         if(k==0){
//             return 1.0;
//         }
//      double sum=0;
//         for(int[] move:moves){
//             int r =row+move[0];
//             int c =col+move[1];
            
//             if(r>=0 && r< n&& c>=0 && c<n){
//                 sum+=sol(n,k-1,r ,c,moves);
//             }
//         }
    
//     return sum/8;
//         }
   
    
    //memoization
  public double knightProbability(int n, int k, int row, int column) {
      
        int[][] moves ={ {-2,-1},{-2,1},{-1,-2},{-1,2},{2,1},{1,-2},{1,2},{2,-1}};  

      double[][][] dp = new double[k+1][n][n]; 
        double nj =sol(n,k,row ,column ,moves ,dp);
        return nj;
    }
    
    
    public double sol(int n ,int k ,int row ,int col,int[][] moves,double[][][] dp){
        
        if(k==0){
            return 1.0;
        }
        if(dp[k][row][col]!=0){
            return dp[k][row][col];
        }
     double sum=0;
        for(int[] move:moves){
            int r =row+move[0];
            int c =col+move[1];
            
            if(r>=0 && r< n&& c>=0 && c<n){
                sum+=sol(n,k-1,r ,c,moves,dp);
            }
        }
     return dp[k][row][col]=sum/8;
    
        }
    
    
    }
