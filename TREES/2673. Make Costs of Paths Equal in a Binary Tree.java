class Solution {
    int ans = 0;
  int dfs(int root,int[] cost, int n){
      if(root > n ) return 0;
      int t1 = dfs(root*2, cost, n);
      int t2 = dfs(root*2+1, cost, n);
      ans += Math.abs(t1 - t2);
      return cost[root-1] + Math.max(t1, t2);
  }
  
  public int minIncrements(int n, int[] cost) {
       dfs(1, cost, n);
     
      return ans;
  }
  
    


}