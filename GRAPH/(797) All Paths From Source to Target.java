class Solution {
    //adjacent list main create karke normal haspath vala  hai
  
  public void DFS(int[][] graph ,int src ,int destination ,boolean[] visited ,List<Integer> path ,List<List<Integer>> paths){
      
    
      visited[src]=true;
    path.add(src);
      
      
      if(src==destination){
         paths.add(new ArrayList<>(path));
  
      }
       
      for(int nbr:graph[src]){
          if(visited[nbr]==false){
          DFS(graph,nbr ,destination ,visited ,path ,paths);
              
              }
              }
      //backtrack
      visited[src]=false;
      path.remove(path.size()-1);
      
  }
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      
      List<Integer> path = new ArrayList<>();
      List<List<Integer>> paths = new ArrayList<>();
      boolean[] visited =new boolean[graph.length];
   DFS(graph ,0,graph.length-1 ,visited,path,paths);
   return paths;
  }
}