class Solution {
    //brute force
    
//     public int kthSmallest(int[][] matrix, int k) {
//     int[] arr = new int[matrix.length*matrix[0].length];
//         int p=0;
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length;j++){
//                 arr[p]=matrix[i][j];
//                 p++;
//             }
//         }
        
//         Arrays.sort(arr);
        
//         return arr[k-1];
//         }
    
    //binary search logic 
    //optimised
       public int kthSmallest(int[][] matrix, int k){
           int lo =matrix[0][0];
           int high =matrix[matrix.length-1][matrix[0].length-1];
           
          
           while(lo<high){
               //ye mid ki technique -ve as well as positive per dono pe chalegi
               int mid =lo+(high-lo)/2;
                int actual =0;
           int j=matrix[0].length-1;
               for(int i=0;i<matrix.length;i++){
                   while(j>=0 && matrix[i][j]>mid){
                       j--;
                   }
                   actual+=j+1; //count hai
               }
               if(actual<k){ //aagr k th smallest se kum count to mtlb right main bda count                                 mill jaega
                   lo=mid+1;
               }else{
                   high=mid;
               }
               
           }
           return lo;//isme kth smallest hoga
       }
}