//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

//DFS
    // List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

    //     int[] vis = new int[v];
    //     int[] pathvis = new int[v];
    //     int[] check = new int[v];
    
    //     for(int i=0;i<v;i++){
            
    //         if(vis[i]==0){
    //             dfscheck(i,adj,vis,pathvis,check);
    //         }
    //     }
    //     List<Integer> safenodes = new ArrayList<>();
        
    //     for(int i=0;i<v;i++){
            
    //         if(check[i]==1){
    //             safenodes.add(i);
    //         }
    //     }
    //     return safenodes;
        
        
    //     }
        
    //     public boolean dfscheck(int node ,List<List<Integer>> adj,int[] vis,int[] pathvis,int[] check){
            
    //         vis[node]=1;
    //         pathvis[node]=1;
    //         check[node]=0;
    //         for(int it:adj.get(node)){
                
    //             if(vis[it]==0){
    //                 if(dfscheck(it,adj,vis,pathvis,check)==true){
    //                     return true;
    //                 }
    //             }else if(pathvis[it]==1){
    //                 return true;
    //             }
    //         }
    //         check[node]=1;//is se pta chal gya node loop main nhi banai ye terminal node hai
    //         pathvis[node]=0;
    //         return false;
    //     }
    
    
    //topological sort bFS khans
     List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
 
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
        
        
 
}
