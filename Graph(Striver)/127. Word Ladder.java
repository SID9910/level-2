
class Pair{
    String first ;
    int second;
    
    Pair(String first, int second){
        
        this.first =first;
        this.second =second;
    }
}
class Solution {
    public int ladderLength(String startword, String targetword, List<String> wordlist) {
    Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(startword ,1));
      Set<String> st = new HashSet<String>();
      
      int len =wordlist.size();
      for(int i=0;i<len;i++){
          
          st.add(wordlist.get(i));
      }
      
      st.remove(startword);
      
      while(!q.isEmpty()){
         String word =q.peek().first;
         int steps =q.peek().second;
         q.remove();
         
         if(word.equals(targetword)==true){
             return steps;
         }
         
         for(int i=0;i<word.length();i++){
             for(char ch='a';ch<='z';ch++){
                 char replaceArray[] = word.toCharArray();
                 replaceArray[i]=ch;
                 String replaceword = new String(replaceArray);
                 
                 if(st.contains(replaceword)==true){
                     st.remove(replaceword);
                     q.add(new Pair(replaceword,steps+1));
                 }
             }
         }
      }
      
      return 0;    
    }
}