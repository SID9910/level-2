class Pair{
    int first;
    int second;
    
    public Pair(int first,int second){
        this.first =first;
        this.second =second;
    }
}
class Solution {
 
 //given fn
 public int numIslands(char[][] grid) {
     int n=grid.length;
     int m=grid[0].length;
     
     int[][] vis = new int[n][m];
     int count=0;
     for(int row =0;row<n;row++){
         for(int col =0;col<m;col++){
             
             if(vis[row][col]==0 && grid[row][col]=='1'){
                 count++;
                 bfs(row,col,vis,grid);
                 
             }
         }
     }
     return count;
 }  
 //bfs
public void bfs(int row,int col,int[][] vis,char[][] grid){
   int n = grid.length,m = grid[0].length;
    vis[row][col] = 1;

     Queue<Pair> q = new LinkedList<Pair>();
     q.add(new Pair(row,col));
     

     while(!q.isEmpty()){
         int r = q.peek().first;
         int c = q.peek().second;
         q.remove();

         for(int drow=-1; drow<=1; drow++){
             for(int dcol=-1; dcol<=1; dcol++){
                 int nrow = r + drow;
                 int ncol = c + dcol;
                   
                 //we dont have to calculate 8 directions 
                 //we only want 4 direction like north,south,east and west 
                 //so we add only this Math.abs(drow-dcol)==1 because of 4                       direction
                 if((Math.abs(drow-dcol) == 1) && (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m) && 
                     vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                     vis[nrow][ncol] = 1;
                     q.add(new Pair(nrow,ncol));
                 }
             }
         }
         }
         }

}