class Solution {
    
    //binary search
    public int findKthNumber(int m, int n, int k) {
      
          int lo =1;
        int high=m*n;
        while(lo<high){
            int actual=0;
            int mid =lo+(high-lo)/2;
            int j=n;
            for(int i=1;i<=m;i++){
                while(j>=1 && i*j>mid){
                    j--;
                }
                actual+=j;
                
                
            }
            if(actual<k){
                lo=mid+1;
            }else{
                high=mid;
            }
            
            
        }
        
        return lo;
        
        
        
    }
}