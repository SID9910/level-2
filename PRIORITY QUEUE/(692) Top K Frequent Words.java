class Solution {
    
  
   
    //optimised isse baad main karunga bucket sort se pehle isse 
    //comparater ko use karna aache se karlu
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new LinkedList<>();
        
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
    
           
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ?  b.compareTo(a): map.get(a) - map.get(b));//-1 means no swap
        
        for(String s : map.keySet()){
            pq.add(s);
            if(pq.size()>k)
                pq.remove();
        }
        while(!pq.isEmpty())
            ans.add(0,pq.remove());
        
        return ans;

    }
}


