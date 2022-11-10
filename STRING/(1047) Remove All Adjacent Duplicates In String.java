class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> st = new Stack<>();
    
        for(char ch:s.toCharArray()){
            if( st.size()>0 && st.peek()==ch){
                st.pop();
            }else{
            
            st.push(ch);
            }
        }
    StringBuilder sb =new StringBuilder();
        while(st.size()>0){
               sb.append(st.pop());
        }
        return sb.reverse().toString(); 
    }

    //another approach
    //  public String removeDuplicates(String S) {
    //    for (int i = 0; i < S.length() - 1; i++) 
    //         if (S.charAt(i) == S.charAt(i + 1)) {
    //             S = S.substring(0, i) + S.substring(i + 2, S.length());
    //             i = -1; // reset to for loop
    //         }
    //     return S;
    // }
}
