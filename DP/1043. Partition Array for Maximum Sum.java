class Solution {
    //recursion
    //     public int maxSumAfterPartitioning(int[] arr, int k) {
    //        int maxsum =maxpartionsum(0 ,arr ,k);
    //         return maxsum;
    //     }
    //     public int maxpartionsum(int i ,int[]arr ,int k){
    //         if(i==arr.length){
    //             return 0;
    //         }
    //         int len =0;
    //         int max =Integer.MIN_VALUE;
    //         int maxans =Integer.MIN_VALUE;
    //         for(int j =i;j<Math.min(arr.length ,i+k);j++){
    //             len++;
    //             max =Math.max(max ,arr[j]);
    //         int sum =len*max +maxpartionsum(j+1 ,arr ,k);    
    //             maxans =Math.max(maxans,sum);
    //         }
    //         return maxans;
    //     }
        
        //memoization
        //     public int maxSumAfterPartitioning(int[] arr, int k) {
        //   int[] dp = new int[arr.length];
        //     for(int i=0;i<dp.length;i++){
        //         dp[i]=-1;
        //     }
        //     int maxsum =maxpartionsum(0 ,arr ,k,dp);
        //     return maxsum;
        // }
        // public int maxpartionsum(int i ,int[]arr ,int k,int[] dp){
        //     if(i==arr.length){
        //         return 0;
        //     }
        //     if(dp[i]!=-1){
        //         return dp[i];
        //     }
        //     int len =0;
        //     int max =Integer.MIN_VALUE;
        //     int maxans =Integer.MIN_VALUE;
        //     for(int j =i;j<Math.min(arr.length ,i+k);j++){
        //         len++;
        //         max =Math.max(max ,arr[j]);
        //     int sum =len*max +maxpartionsum(j+1 ,arr ,k,dp);    
        //         maxans =Math.max(maxans,sum);
        //     }
        //     return dp[i]=maxans;
        // }
        
        //tabulation
           public int maxSumAfterPartitioning(int[] arr, int k) {
        int n =arr.length;
               int[] dp = new int[n+1];
            
               dp[n]=0;
               
               for(int i=n-1;i>=0;i--){
                 
            int len =0;
            int max =Integer.MIN_VALUE;
            int maxans =Integer.MIN_VALUE;
            for(int j =i;j<Math.min(arr.length ,i+k);j++){
                len++;
                max =Math.max(max ,arr[j]);
            int sum =len*max +dp[j+1];    
                maxans =Math.max(maxans,sum);
            }
            dp[i]=maxans;  
               }
          
            return dp[0];
            
        }
      
        
        
        }