class Pair{
    int row;
    int col;
    int tm;
    
     Pair(int _row ,int _col ,int _tm){
         this.row =_row;
         this.col =_col;
         this.tm =_tm;
     }
}

class Solution {

   //bfs
   public int orangesRotting(int[][] grid) {

       int n=grid.length;
       int m=grid[0].length;
       
       int countfresh =0;
       
       int[][] vis = new int[n][m];
       Queue<Pair> q = new LinkedList<Pair>();
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==2){
                   q.add(new Pair(i,j,0));
                   vis[i][j]=2;
               }else{
                   vis[i][j]=0;
               }
               
               if(grid[i][j]==1){
                   countfresh++;
               }
               
           }
       }
       int count =0;
       
       int[] delrow ={-1,0,+1,0};
       int[] delcol ={0,1,0,-1};
       int tm =0;
       
       while(!q.isEmpty()){
           
           int row =q.peek().row;
           int col =q.peek().col;
           int t=q.peek().tm;
             tm =Math.max(tm,t);
           q.remove();
            for(int i=0;i<4;i++){
           int nrow =row+delrow[i];
           int ncol =col+delcol[i];
         
           if(nrow>=0 && nrow<n && ncol<m && ncol>=0 && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
         q.add(new Pair(nrow ,ncol ,t+1));
               vis[nrow][ncol]=2;
               count++;
           
           }
       }
         
   }
       if(count!=countfresh){
           return -1;
       }
       return tm;
   } 
}