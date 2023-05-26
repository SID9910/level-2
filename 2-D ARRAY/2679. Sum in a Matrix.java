class Solution {
    public int matrixSum(int[][] nums) {
     
        int count =0;
        for(int[] rows:nums){
            Arrays.sort(rows);
        }
        
        for(int j=0;j<nums[0].length;j++){
            int m=0;
            for(int i=0;i<nums.length;i++){
                if(m<nums[i][j]){
                    m=nums[i][j];
                }
                
            }
            count+=m;
        }
        return count;
    }
}