class Solution {
    //dp memorization hai
    Integer[][] memo;
    int[] nums;
    int[] multipliers;
    int N;
    int M;

    public int maximumScore(int[] nums, int[] multipliers) {

        // First assign the values of multipliers and nums.
        this.nums = nums;
        this.multipliers = multipliers;
        N = nums.length;
        M = multipliers.length;

        // If the N >= M * 2, then we will remove the middle numbers from nums, since the middle is unreachable.
        // We will only keep the first M-th and last M-th numbers that is reachable by the multipliers.
        if (N >= M * 2) {
            int[] newNums = new int[M * 2];
            System.arraycopy(nums,0,newNums,0, M);
            System.arraycopy(nums,N - M,newNums,M, M);
            this.nums = newNums;
        }

        // Set up a memo for the dynamic programming with memoization.
        memo = new Integer[this.nums.length][this.nums.length];

        // See below for the explanation for the memoization method.
        return memoization(0, this.nums.length - 1, 0);
    }

    // Memoization involves saving the optimum solution from the previous operation for easy retrieval.
    // This is so that we can avoid repeating the operation, thus lowering time complexity.
    private int memoization(int front, int back, int current) {
        // Breaking condition, when the current pointer reaches the end of the multipliers array.
        // Thus, the recursion will propagate from back to front of the multiplier array,
        // and from center to ends of the nums array.
        if (current == M) {
            return 0;
        }
        if (memo[front][back] != null) {
            return memo[front][back];
        }

        // Get the higher values of multiplication between the front and back of nums.
        int left = nums[front] * multipliers[current] + memoization(front + 1, back, current + 1);
        int right = nums[back] * multipliers[current] + memoization(front, back - 1, current + 1);
        memo[front][back] = Math.max(left, right);

        // Each time the memoization is called, the value is updated with total score from the multiplications.
        return memo[front][back];
    }
}