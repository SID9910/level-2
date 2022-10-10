class Solution {
    //tc-0(n)
    //space-o(n)
    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();

        int n = s.length;
if(n==1){
    return "";
}
        
        for (int i = 0; i < n / 2; i++) {

            if (s[i] != 'a') {

                s[i] = 'a';

                return String.valueOf(s);

            }

        }
//for all a
        s[n - 1] = 'b'; 

        return String.valueOf(s);
    }
}