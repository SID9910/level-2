class Solution {
    //kmp  logic
   public String shortestPalindrome(String s) {
    //add reverse to it
    String str =s+"$"+ new StringBuilder(s).reverse().toString(); 
       int[] lps = new int[str.length()];
       int i=1;
       int len=0;
       while(i<str.length()){
           if(str.charAt(i)==str.charAt(len)){
               len++;
               lps[i]=len;
               i++;
           }else{
               if(len>0){
                   len=lps[len-1];
                   
               }else{
                   lps[i]=0;
                   i++;
               }
           }
       }
       int ppl =lps[str.length()-1]; //get last
       String right=s.substring(ppl);//aage ke saare
       return new StringBuilder(right).reverse().toString()+s;//reverse add karo start main
       
   }
}