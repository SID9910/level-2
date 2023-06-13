class Solution {
    //adjacent list main create karke normal haspath vala logic hai
     class Graph{
         public ArrayList<Integer>[] adj;
         Graph(int n){
             adj =new ArrayList[n];
             for(int i=0;i<n;i++){
                 adj[i]=new ArrayList<>();
             }
         }
         public void addEdge(int src,int dest){
             adj[src].add(dest);
             adj[dest].add(src);
         }
     }
    public boolean DFS(Graph graph ,int src ,int destination ,boolean[] visited){
        if(src==destination){
            return true;
        }
        visited[src]=true;
        for(int nbr:graph.adj[src]){
            if(visited[nbr]==false){
            boolean hashpath =DFS(graph,nbr ,destination ,visited);
                if(hashpath==true){
                    return true;
                }
                }
                }
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       Graph graph = new Graph(n);
        for(int i=0;i<edges.length;i++){
            graph.addEdge(edges[i][0],edges[i][1]);
        }
        boolean[] visited =new boolean[n];
        return DFS(graph ,source,destination ,visited);
    }
}