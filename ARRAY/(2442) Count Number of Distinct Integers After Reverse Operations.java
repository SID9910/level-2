class Solution {
    // brute force
    //     public int countDistinctIntegers(int[] nums) {
       
    //      int[] arr = new int[2*nums.length];
    //     for(int i=0;i<nums.length;i++){
    //         arr[i]=nums[i];
    //     }
        
    //     for(int i=0;i<nums.length;i++){
    //          if(nums[i]<=9){
    //              arr[nums.length+i]=nums[i];
    //              }else{
                 
    //              //reverse operation
    //              int res=0;
    //              int n=nums[i];
    //              while(n!=0){
    //     int d =n%10;
    //     res =res*10+d;
    //     n/=10;
                      
             
    // }
    //      arr[nums.length+i]=res;
               
                       
    // }
             
                 
    //          }
            
    //          Set<Integer> set = new HashSet<>();
    //         for(int n: arr){
    //             set.add(n);
               
    //      }
        
    //         return set.size();//distinct 
    //     }
    // }
        //tc=0(n) space-0(n)
        public int countDistinctIntegers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int n: nums){
                set.add(n);
                set.add(reverse(n));
            }
            return set.size();//saare distinct vale honge isme
        }
        
         int reverse(int n){
            int rev = 0;
            while(n != 0){
                int rem = n % 10;
                rev = rev* 10 + rem;
                n /= 10;
            }
            return rev;
        }
    
        }
    
    
    