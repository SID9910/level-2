//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class GFG
    {
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
            while(t-->0){
                
                int n = Integer.parseInt(br.readLine().trim());
                String inputLine[] = br.readLine().trim().split(" ");
                int arr[] = new int[n];
                for(int i=0; i<n; i++){
                    arr[i] = Integer.parseInt(inputLine[i]);
                }
                
                int k = Integer.parseInt(br.readLine().trim());
                
                Solution ob= new Solution();
                System.out.println(ob.countKdivPairs(arr, n, k));
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    class Solution
    {
        public static long countKdivPairs(int arr[], int n, int k)
        {
        //   int rem=0;
            
        //     HashMap<Integer ,Integer> map = new HashMap<>();
            
        //     for(int i=0;i<arr.length;i++){
        //     rem=arr[i]%k;
            
        //      if(map.containsKey(rem)){
        //          map.put(rem ,map.get(rem)+1);
        //      }else{
        //          map.put(rem,1);
        //      }
        //     }
            
        //     int count=0;
        //     for(int i=0;i<k;i++){
                
        //         if(i==0){
        //             count+=((map.get(0))(map.get(0)-1))/2;
        //         }
                
                 long count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int item: arr){
                int rem = item % k;
                if(rem != 0){
                    count += map.getOrDefault((k-rem), 0);
                } else {
                    count += map.getOrDefault(0, 0);
                }
                map.put(rem, map.getOrDefault(rem, 0)+1);
            }
            
            return count;
                
            
        }
    }