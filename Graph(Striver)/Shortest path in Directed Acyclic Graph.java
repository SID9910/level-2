//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends




class Pair{
    int first;
    int second;
    
    Pair(int first ,int second){
        this.first =first;
        this.second =second; //act as weight
    }
}
class Solution {



	public int[] shortestPath(int N,int M, int[][] edges) {
    
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       
       for(int i=0;i<N;i++){
           ArrayList<Pair> temp = new ArrayList<Pair>();
           adj.add(temp);
       }
       
       for(int i=0;i<M;i++){
           int u=edges[i][0]; //source
           int v=edges[i][1];//destination
           int wt=edges[i][2]; //weight
           
           adj.get(u).add(new Pair(v,wt)); //source ke correspoing dest and weight daaln dey
           
       }
       int[] vis = new int[N];
       
       Stack<Integer> st = new Stack<>();
       
       for(int i=0;i<N;i++){
           toposort(i,adj,vis,st);
       }
       
       int[] dist = new int[N];
       for(int i=0;i<N;i++){
           dist[i]=(int)(1e9);
       }
       //assume source as zero given
       dist[0]=0;
       while(!st.isEmpty()){
           int node =st.peek();
           st.pop();
           for(int i=0;i<adj.get(node).size();i++){
               int v=adj.get(node).get(i).first ;// neighbour node
               int wt=adj.get(node).get(i).second ;//weight
               
               if(dist[node]+wt<dist[v]){
                   dist[v]=wt+dist[node];
               }
           }
       }
       for(int i=0;i<N;i++){
           if(dist[i]==1e9){
               dist[i]=-1;
           }
          
       }
        return dist;
	}
	
	
	//DFS
	public void toposort(int node ,ArrayList<ArrayList<Pair>> adj,int[] vis ,Stack<Integer> st){
	    
	    vis[node]=1;
	    for(int i=0;i<adj.get(node).size();i++){
	        int v =adj.get(node).get(i).first; //isme neighbour nodes hongi us particular node ke 
	       if(vis[v]==0){
	           toposort(v,adj,vis,st);
	       }
	    }
	    st.add(node);
	}
}