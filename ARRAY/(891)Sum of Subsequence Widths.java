class Solution {
    long MOD =1000000007L;//modules ki length 107
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long ans =0;
        long power=1; //2 power 0
    int i=0;
        int j=nums.length-1;
        while(i<nums.length && j>=0){
            ans=(ans+power*nums[i]-power*nums[j])%MOD; //mod jaurur lena
            power =(power*2)%MOD;
            j--;
            i++;
        }
        return (int)ans;
        
    }
}