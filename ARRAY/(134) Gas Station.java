class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     int currentsum =0;//aab taak ka sum lelo
        int totalsum =0;//pure total ka sum
        int startpoint =0;//ye return kar denge
        for(int i=0; i<gas.length;i++){
            totalsum +=(gas[i]-cost[i]); 
            currentsum +=(gas[i]-cost[i]);
            if(currentsum<0){ //aagr negative then mtlb aab udher se chalu kardo
                currentsum =0;
                startpoint =i+1;
            }
        }
        //ye honi chaheye true taab he return 
        if(totalsum >=0){
            return startpoint;
        }else{
            return -1;//unsuccessful search
            
        }
        
        
    }
}