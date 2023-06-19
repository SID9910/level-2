class Solution {
  // BFS
  // public boolean isBipartite(int[][] graph)
  // {
  // int n = graph.length;
  // int color[] = new int[n];
  // Arrays.fill(color,-1);
  // for(int i=0;i<n;i++)
  // {
  // if(color[i] == -1)
  // {
  // if(check(i, graph, color) == false)
  // return false;

  // }
  // }
  // return true;
  // }

  // private boolean check( int start,int graph[][], int color[])
  // {
  // Queue<Integer> q = new LinkedList<Integer>();
  // q.add(start);
  // color[start] = 0;
  // while( !q. isEmpty())
  // {
  // int node = q.peek();
  // q. remove();

  // //bss graph aaise chalega isme row wise
  // for(int it : graph[node])
  // {
  // // if the adjacent node is yet not colored
  // // you will give the opposite color of the node
  // if(color[it] == -1)
  // {
  // color[it] = 1 - color[node];
  // q.add(it);
  // }
  // //is the adjacent guy having the same color
  // //someone did color it on some other path
  // else if(color[it] == color[node])
  // {
  // return false;
  // }
  // }
  // }
  // return true;
  // }

  // DFS
  public boolean isBipartite(int[][] graph) {
    int n = graph.length; // act as vertex
    int color[] = new int[n];
    Arrays.fill(color, -1);
    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (DFS(i, 0, color, graph) == false)
          return false;

      }
    }
    return true;
  }

  private boolean DFS(int node, int col, int[] color, int[][] graph) {

    color[node] = col;

    // bss graph aaise chalega isme row wise
    for (int it : graph[node]) {
      if (color[it] == -1) {
        if (DFS(it, 1 - col, color, graph) == false) {
          return false;
        }
      } else if (color[it] == color[node]) {
        return false;
      }
    }

    return true;
  }

}