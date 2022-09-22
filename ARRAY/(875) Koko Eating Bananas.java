class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int low =1;//speed
        int high =0;//highest speed
        for(int pile:piles){
            high =Math.max(pile ,high);
        }
        
        while(low<high){
            int allowedspeed =(low+high)/2;//allowed spped
            
            
            int totalTime =0;
             for(int pile:piles){
                 int time =(pile+allowedspeed-1)/allowedspeed;
                 totalTime+=time;
             }
            
            //speed bdao
            if(totalTime>h){
                low =allowedspeed+1;
            }else{
                high =allowedspeed;//speed kuym karo or ho saake to
            }
            
        }
        return low;//least speed
    }
}