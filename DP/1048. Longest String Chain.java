class Solution {
    public int longestStrChain(String[] words) {
     int[] dp = new int[words.length];
 
   for (int i=0;i<dp.length;i++){
       dp[i]=1;
   }
   int maxi =1; //khud ho sakta hai
  int lastindex =0;
  Arrays.sort(words,Comparator.comparingInt(String::length));
   for(int index=0;index<words.length;index++){
      
       for(int prev=0;prev<index;prev++){
           if(compare(words[index],words[prev]) && 1+dp[prev] >dp[index]){
               dp[index]=1+dp[prev];
               
           }
       }
       if(dp[index]>maxi){
           maxi =dp[index];
        
       }
       
   }
return maxi;
    
    }
    
    public boolean compare(String s1 ,String s2){
        if(s1.length()!=s2.length()+1){
            return false;
        }
        int first =0;
        int second =0;
        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first ==s1.length() && second==s2.length()){
            return true;
        }
        return false;
    } 
}