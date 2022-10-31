class Solution {
    public int minDeletions(String s) {
    int deletion =0;
        int[] freq = new int[26];
        for(char val:s.toCharArray()){
            freq[val-'a']++;
        }
        
        Set<Integer> uniqueFrequency = new HashSet<Integer>();
        for(int count: freq){
            //uska count kaam kardo
            while(count>0 && uniqueFrequency.contains(count) ){
               count--;
                deletion++;
            }
            //unique aagar count to kardo
            uniqueFrequency.add(count);
        }
        return deletion;
    }
}