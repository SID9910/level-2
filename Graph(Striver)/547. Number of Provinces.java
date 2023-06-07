class Solution {
    //0 based indexing hai question
    public int findCircleNum(int[][] isConnected) {
      ArrayList<ArrayList<Integer>> adjlis = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<isConnected.length;i++){
            adjlis.add(new ArrayList<Integer>());
        }
        //to change adjacency matrix to list
        
        for(int i=0;i<isConnected.length;i++){
            for(int j=0; j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjlis.get(i).add(j);
                    adjlis.get(j).add(i);
                }
            }
        }
        //0 based indexing hai
        int[] vis =new int[isConnected.length];
        
        int count=0;
        
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adjlis,vis);
            }
        }
        return count;
    }
    
    //DFS
    public void dfs(int node ,  ArrayList<ArrayList<Integer>> adjlis ,int[] vis){
        vis[node]=1;
        for(Integer it: adjlis.get(node)){
          if(vis[it]==0){
              dfs(it,adjlis,vis);
          }  
        }
    }
}