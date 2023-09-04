
//ye haibb
class Pair{
    int first;
    int second;
    
    public Pair(int first,int second){
        this.first =first;
        this.second =second;
    }
}
class Solution {
 //not done yet 
 
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

          //main khud isse dfs se kara hai eek or approach
    //assume 4 directions only
    public int numIslands(char[][] grid) {
     int n=grid.length;
     int m=grid[0].length;
     
        int[][] vis = new int[n][m];
        
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]=='1' && vis[i][j]==0){
                    count++;
                    dfs(i ,j ,grid ,vis);
                }
            }
        }
        return count;
    }
    
    public static  void dfs(int i ,int j ,char[][] grid ,int[][] vis){
             int n=grid.length;
     int m=grid[0].length;
        vis[i][j]=1;
        
        for(int delr=-1;delr<=1;delr++){
            for(int delc=-1;delc<=1;delc++){
                int r =i+delr;
                int c =j+delc;
                
                if( Math.abs(delr-delc)==1 && r>=0 && r<n && c>=0 && c<m && vis[r][c]==0 && grid[r][c]=='1'){
                    dfs(r,c,grid ,vis);
                }
            }
        }
        
        }

}