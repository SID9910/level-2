class Solution {
    //not optimised
    //priority queue
    //tc-nlogk
   public  class Pair implements Comparable <Pair>{
        int val;
        int gap;
        
        Pair(){
            
        }
        Pair(int val ,int gap){
            this.val =val;
            this.gap =gap;
        }
        public int compareTo(Pair o){
            //aagr gap nbaharabar pairs ka then 
            //compare on basis of value 
            //jiski kum usse ppreference denge max heap main
            if(this.gap ==o.gap){
                return this.val -o.val;
            }else{
                //jiska gap kum usse preference
                return this.gap-o.gap; 
            }
            
        }
        
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       List<Integer> list = new ArrayList<>();//isme store karlo
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());//max heap
        
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
            }else{
                if(pq.peek().gap>Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
                }
            }
        }
        
        while(pq.size()>0){
        Pair rem =pq.remove();
            list.add(rem.val);
            
        }
        Collections.sort(list);//increasing order
        return list;
    }
}