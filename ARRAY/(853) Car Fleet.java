class Solution {
    
    //we use comparable because we are arranging positions
    //in sorted form 
    class Car implements Comparable<Car> {
        int position;
        int speed;
        //constructor
        Car(int position , int speed){
            this.position =position;
            this.speed = speed;
        }
        public int compareTo(Car c){
            return c.position -this.position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        //increasing order main daal hay priority queue main
        for(int i=0;i<position.length;i++){
            Car c = new Car(position[i],speed[i]);
            pq.add(c);
        }
        int groups =0;//count aaega number of groups ka isme 
        double time =0;///time ke basis per group divide karenge
        while(pq.size()>0){
            Car c =pq.remove();
            double currenttime= (target-c.position)*1.0 /c.speed;
            
            //aagr vo time ke group se jada hua mtlb nya group main aaega vo
            if(currenttime>time){
                time =currenttime;
                groups++;
            }
        }
        return groups;
    }
}