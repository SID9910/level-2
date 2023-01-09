class Solution {
    //different approach
    // public String reverseWords(String s) {
    //     String[] words =s.trim().split(" +");
    //     Collections.reverse(Arrays.asList(words));
    //     return String.join(" " ,words);
    // }


//two pointer approach hai
     public String reverseWords(String s) {
     StringBuilder result = new StringBuilder();
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)==' '){
            continue;
        }
        int start =i;
        while(i<s.length() && s.charAt(i)!=' '){
            i++;
        }
        if(result.length()==0){
            result.insert(0,s.substring(start ,i));

        }else{
            result.insert(0," ").insert(0,s.substring(start ,i));
        }
     }
     return result.toString();
     
        }
}