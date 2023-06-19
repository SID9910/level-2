//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    // public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {

    //   int[] vis = new int[v];
    //   int[] pathvis =new int[v];
      
    //   for(int i=0;i<v;i++){
          
    //       if(vis[i]==0){
    //           if(dfscheck(i,adj ,vis ,pathvis)==true){
    //               return true;
    //           }
    //       }
    //   }
    //   return false;
    // }
    
    // public boolean dfscheck(int node ,ArrayList<ArrayList<Integer>> adj ,int[] vis ,int[] pathvis){
    //     vis[node]=1;
    //     pathvis[node]=1;
        
    //     for(int it:adj.get(node)){
    //         if(vis[it]==0){
    //             if(dfscheck(it ,adj ,vis, pathvis)==true){
    //                 return true;
    //             }
    //             }else if(pathvis[it]==1){
    //                 return true;
    //             }
            
    //     }
    //     pathvis[node]=0;
        
    //      return false;
        
    // }
    
    //KHANS TOPOLOGICAL  SORT BFS
     public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[v];
        
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                
                indegree[it]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        
        int count =0;
        int i=0;
        
        while(!que.isEmpty()){
            int node  =que.peek();
            que.remove();
            count++;
            
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    que.add(it);
                }
            }
        }
        if(count==v){
            return false;
        }
        return true;
        
    }

}