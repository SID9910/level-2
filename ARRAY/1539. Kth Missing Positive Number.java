class Solution {
    
    //o(n)
//     public int findKthPositive(int[] arr, int k) {
//         Set<Integer> set = new HashSet<>();

//         for(int el: arr){
//             set.add(el);
//         }

//         int count = k;
//         int start =1;
//         while(count>0){
//             if(set.contains(start)){
//                 start++;
//             } else {
//                 count--;
//                 start++;

//             }
//         }

//         return start-1;
//     }
    
    //another 0(n) approach
      public int findKthPositive(int[] arr, int k) {
          if(arr[0]>k){
              return k;
          }
          for(int a:arr){
              if(a<=k){
                  k++;
              }else{
                  break;
              }
              
          }
          
          
          return k;
      }
      // TC O(logn) , SC O(1)
//     public int findKthPositive(int[] arr, int k) {
//         int low = 0;
//         int high = arr.length;
//         while(low<high){
//             int mid = (high -low)/2 + low;

//             if(arr[mid] -(mid +1) >= k){
//                 high = mid;
//             } else{
//                 low =mid+1;
//             }
//         }

//         return low +k;
//     }
}