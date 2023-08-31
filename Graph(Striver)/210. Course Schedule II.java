class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList < ArrayList < Integer >>adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }


        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int ans[]=new int[numCourses];
        int i=0;
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            ans[i++]=node;
            
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(i==numCourses) return ans;
        int arr[]={};
        return arr;
    }
}