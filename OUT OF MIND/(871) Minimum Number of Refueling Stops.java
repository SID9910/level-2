class Solution {
    

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, count = 0, far = startFuel;
        while(far < target){
            while(i<stations.length && stations[i][0] <= far){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.size()==0)
                return -1;
            far += pq.remove();
            count++;
        }
        return count; 
    }
}