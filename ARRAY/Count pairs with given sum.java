//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    //optimised
    int getPairsCount(int[] arr, int n, int k) {
       // code here
       int c = 0;
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       
       for(int i : arr) {
           if(map.containsKey(k-i))
           c += map.get(k-i);
           if(!map.containsKey(i))
           map.put(i, 1);
           else
           map.put(i, map.get(i)+1);
       }
       return c;
   }
}
    //n2 not optimised hashmap se karunga isse baad main optimised
    // int getPairsCount(int[] arr, int n, int k) {
        // brute force
//       int count=0;
//       for(int i=0;i<n;i++)
//       {
//           for(int j=i+1;j<n;j++)
//           {
//               if(a[i]+a[j] == k)
//                   count++;
//           }
//       }
//       return count;
//       */
//   }
        
        
        //not optimised hashmap se karunga
//          int count=0;
//       int left=0,right=n-1;
//       Arrays.sort(arr);
      
//       while(left<right){
//           if(arr[left]+arr[right] > k){
//               right--;
//           }
//           else if(arr[left]+arr[right] < k){
//               left++;
//           }
          
//           if(arr[left] + arr[right] == k){
//               int x = arr[left];
              
//               //ho sakta hai kya paata start se or pair ban rahe ho
//               for(int i=left+1; i<=right; i++){
//                   if(x + arr[i] == k){
//                       count++;
//                   }
//               }
//               left++;
          
              
//           }
//       }
      
//       return count;
// }
// }