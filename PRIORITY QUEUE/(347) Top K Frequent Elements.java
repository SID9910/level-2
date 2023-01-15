class Solution {
    //optimised
    //bucket sort sikh kar karunga us se bhi nhi
    
    //priority queue (brute force)
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer,Integer> map = new HashMap<>();
        
        //pehle frequency bhar lo
        for(int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //ye jiski frequency jda usse top per rakhega
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) ->
                                                            map.get(b)-map.get(a));

        
        //priority queue main aab bss high to low frequency bhari hai
         for(int key:map.keySet()){
             maxHeap.add(key);
         }
        
        //bss fill karlo
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=maxHeap.remove();
        }
        return res;
        
    }
}

