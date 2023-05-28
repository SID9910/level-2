class Solution {
  //approach-1    dp(memorisation)
      
  //     public int fib_mem(int N , int[] strg){
       
  //        if(N==0 || N==1){
  //            return N;
  //        }
  //        if(strg[N]!=0){
  //            return strg[N];
  //        }
  //        int fib1 = fib_mem(N-1,strg);
  //        int fib2 = fib_mem(N-2,strg);
         
  //        int totalfib =fib1+fib2;
  //        strg[N]=totalfib;
  //        return totalfib;   
  //     }
  //    public int fib(int N) { 
        
  //        int fibonacci =fib_mem(N ,new int[N+1]);
  //        return fibonacci;
         
  //                          }
      
  // }
   //Base Condition
         
          
  //approach-2 dp tabulation
      
     public int fib(int N) { 
          if(N==0)
              return 0;
         
         
         int[] strg = new int[N+1];
         
         strg[0]=0;
         strg[1]=1;
         for(int i=2;i<=N;i++){
             if(i-1>=0){
                 strg[i]+=strg[i-1];
             }
             if(i-2>=0){
                 strg[i]+=strg[i-2];
             }
         }
        return strg[N]; 
     }    
  }
      
      
      //approach-3 iterative 
      // public int fib(int N) { if(N <= 1) return N; 
      //  int a = 0, b = 1;
      // while(N-- > 1) {
      //   int sum = a + b;
      //  a = b;
      //  b = sum;
      //   }
      // return b;
      //                       }                          
      
      //approach-4 recussion
      //  public int fib(int N)
      // {
      //     if(N <= 1)
      //         return N;
      //     else
      //         return fib(N - 1) + fib(N - 2);
      // }
  