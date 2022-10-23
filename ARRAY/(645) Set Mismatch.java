class Solution {
    //explained
//     Assume input arr is [1,2,3,1,5].

// To find duplicate I'm using a visited boolean array of fixed size 10^4.
// It's guaranteed that we only have one duplicate and numbers range from 1 to 10^4.
// Simultaneously find out the sum of input natural numbers.

// In the example we consider,
// sum = 1+2+3+1+5 = 12, duplicate number is 1, and sum of natural numbers till 5 is (5 * (5+1)) / 2 = 15

// now we add the difference of sum of first N natural numbers and input arr sum to duplicate to get the value missed in the sequence.

// i.e, 1 + (15 - 12) = 1 + 3 = 4 is the missed number in the sequence
    
    
    
    //tc-0(n)
    public int[] findErrorNums(int[] nums) {
  
	boolean[] visited = new boolean[10001];
	int duplicate = 0, sum = 0, n = nums.length;
	for (int i: nums) {
		if (visited[i]) {
			duplicate = i;
		}
		visited[i] = true;
		sum += i;
	}
	int nsum =  (n * (n+1)) / 2;
	return new int[] {duplicate, duplicate + nsum - sum};
    
    }
    
    //approach -2
//     public int[] findErrorNums(int[] nums) {  
        
//         HashSet<Integer> h = new HashSet<>();
//         int dup=0;
//         for(int n : nums){
//             if(h.contains(n))
//                 dup=n;
//             h.add(n);
//         }
               
//         for(int i=1;i<=nums.length;i++){
//             if(!h.contains(i))
//                 return new int[]{dup,i};
//         }
        
//         return new int[]{};
//     }
}