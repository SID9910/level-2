class Solution {
    //O(n)
    public boolean isAnagram(String s, String t) {
     int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++){
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++){
            alphabet[t.charAt(i) - 'a']--;
            }
       //agr eek word bhi extra aagya then false
        for (int val : alphabet) {
            if ( val!= 0) return false;
        }
        return true;   
    }
}