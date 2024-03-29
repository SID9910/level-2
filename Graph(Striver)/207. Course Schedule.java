
class Solution {
    public boolean canFinish(int v, int[][] prerequisites) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
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
            return true;
        }
        return false;   
    }
}