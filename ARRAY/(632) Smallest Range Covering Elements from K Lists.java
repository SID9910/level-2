class Solution {
    class Pair implements Comparable<Pair> {
        int li;//list
        int di;//data index
        int val;//value
        
        Pair(int li,int di , int val){
            this.li =li;
            this.di =di;
            this.val =val;
            
        }
        
        public int compareTo(Pair o){
            return this.val -o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int max =Integer.MIN_VALUE;
        //is loop se bss hum har list ka first element he daal rahe hai
        //and max bhi bss har list ka pehle main se he le rahe hai
        for(int i=0;i<nums.size();i++){
            pq.add(new Pair(i,0,nums.get(i).get(0)));
            max =Math.max(max,nums.get(i).get(0));
        }
        
        int rangebeg =0;//range start
        int rangeend =0;//range end 
        int rangesize =Integer.MAX_VALUE;
        while(pq.size()==nums.size()){//bss jaab taak list ho
            Pair p =pq.remove();
            int crsize =max-p.val;
            if(crsize<rangesize){
                rangesize =crsize;
                rangebeg =p.val;
                rangeend =max;
            }
            
            //aage travel ke ley
            if(p.di <nums.get(p.li).size()-1){
                p.di++;
                p.val = nums.get(p.li).get(p.di);
                pq.add(p);
                //aagr max se bda to update
                if(p.val>max){
                    max=p.val;
                }
            }
            
        }
        //range
        return new int[] {rangebeg,rangeend};
    }
}










