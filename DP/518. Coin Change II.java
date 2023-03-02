class Solution {
    //recursion
//     public int combination(int index ,int[] coins ,int amount){
//         if(index==0){
//         if( amount%coins[0]==0){
//          return 1;   
//         }else{
//             return 0;
//         }
            
//         }
//         int nottake =combination(index-1,coins ,amount);
//         int take =0;
//         if(coins[index]<=amount){
//             take =combination(index ,coins ,amount-coins[index]);
//         }
//         return take+nottake;
        
//     }
    
//     public int change(int amount, int[] coins) {
//         int ans =combination(coins.length-1 ,coins ,amount);
//         return ans;
//     }
    
    //memoization
    
// public int change(int k, int[] a) {
// int i,j,n=a.length;

//  int dp[][] = new int[n][k+1]; //size would be dp[N][target+1];
//     for(i=0;i<n;i++)
// 	{
// 	    for(j=0;j<k+1;j++)
// 	    {
// 	        dp[i][j]=-1;
// 	    }
// 	}
//     int ans = func(n-1,k,a,dp);
//     return ans;
// }
//  public int func(int index, int target, int a[], int [][]dp)
// {
//     //base case 
//     if(index==0)
//     {
//         if(target%a[0]==0)
//         return 1;
        
//         else
//         return 0;
//     }
    
//     if(dp[index][target]!=-1)
//     return dp[index][target];
    
//     //pick-notPick logic
//     int notPick = func(index-1, target, a, dp);
//     int pick = 0;
//     if(a[index]<=target)
//     pick = func(index, target-a[index], a, dp);
    
//     return dp[index][target] = pick+notPick;
// }
    
    //tabulation
    public int change(int amount, int[] coins) {
int n=coins.length;

 int dp[][] = new int[n][amount+1]; //size would be dp[N][target+1];
  
        for(int i=0;i<=amount;i++){
             if (i % coins[0] == 0)
            {
                dp[0][i] = 1;
            }
            
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                
    int notPick = dp[i-1][j];
    int pick = 0;
    if(coins[i]<=j)
    pick = dp[i][j-coins[i]];
                
                dp[i][j]=pick+notPick;
            }
            
            
        }
        return dp[n-1][amount];
    }
    
}