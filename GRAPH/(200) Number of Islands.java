class Solution {
    public int numIslands(char[][] grid) {
     boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
         
    if (grid.length == 0) return 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    Drawforcomponenet(grid,i,j,visited);
                    count++;
                }
                
            }
        }
    return count;
    }
    
    public void Drawforcomponenet(char[][] grid ,int i,int j,boolean[][] visited ){
        if(i<0|| j<0 ||i>=grid.length ||j>=grid[0].length ||grid[i][j]=='0' || visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        Drawforcomponenet(grid,i+1,j,visited);
        Drawforcomponenet(grid,i-1,j,visited);
        Drawforcomponenet(grid,i,j+1,visited);
        Drawforcomponenet(grid,i,j-1,visited);
    }
    
}