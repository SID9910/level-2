class Solution {
    //     Logic:
    // If the current value(i,j) is 1 then the next value in the column(i,j+1) should also be 1.
    // Then, check for next row next col (i+1,j+1)
    
    // If the current value(i,j) is -1 then the prev value of the column(i,j-1) should also be -1.
    // Then, check for next row prev col(i+1,j-1)
    
    // If any of the condition fail or goes out of bounds that ball won't reach the end.
      public int dfs(int[][] grid, int i, int j){
            if(i==grid.length)
                return j;
            
            if(j<0 || j>=grid[0].length)
                return -1;
            
            if(grid[i][j]==1 && j+1<grid[0].length && grid[i][j+1]==1)
                return dfs(grid,i+1,j+1);
            
            else if(grid[i][j]==-1 && j-1>=0 && grid[i][j-1]==-1)
                return dfs(grid,i+1,j-1);
             
            return -1;
        }
        public int[] findBall(int[][] grid) {
            int m = grid[0].length;
            int[] ar = new int[m];
            
            for(int j=0;j<m;j++)
                ar[j]=dfs(grid,0,j);
            
            return ar;
        }
    }