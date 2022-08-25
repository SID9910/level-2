class Solution {
    public String toLowerCase(String s) {
       StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='A' && ch<='Z'){
                char lc =(char)(ch+ 'a'-'A');
                sb.setCharAt(i,lc);
            }
        }
        return sb.toString();
    }
}