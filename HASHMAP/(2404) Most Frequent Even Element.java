class Solution {
    public int mostFrequentEven(int[] nums) {
        // using map to record the even elements count
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            //put even element into map
            if(nums[i]%2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
        }
        int maxCount = -1; // max count
        int minResult = -1; // min even element
        for(int key: map.keySet()) {
            //get the max count of even element
            /*1. if count is bigger, then maxCount change to the current maxCount
            *     and update the current min even element
			*/
            if(map.get(key) > maxCount) {
                maxCount = map.get(key);
                minResult = key;
            }
            //2. if count is the same, compare which even element is smaller
            else if(map.get(key) == maxCount) {
                minResult = Math.min(minResult, key);
            }
            
        }
        return minResult;
}
}