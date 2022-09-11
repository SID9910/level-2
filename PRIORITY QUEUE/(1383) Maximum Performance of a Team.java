class Solution {
    //tc-nlog(n)
    //space-o(n)
    //class describe
    public class Engineer{
        int speed;
        int efficiency;
        public Engineer(int speed, int efficiency){
            this.speed =speed;
            this.efficiency=efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //add in list
        List<Engineer> engineers = new ArrayList<>();
        for(int i=0;i<n;i++){
            engineers.add(new Engineer(speed[i],efficiency[i]));
        }
        //now sort the engineers list by their respective efficiency
        engineers.sort((a,b)-> b.efficiency-a.efficiency);
        
        //will keep slowest members at the top ,fastest ones stay in the team longest
        //slowest speed vala pehle niklega kyuki top per vo rahega
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a,b)->a.speed-b.speed);
        
        long TeamSpeed=0;
        long maxPerformance =0;
        //sab per chalega
        for(Engineer val:engineers){
            //jaab size k ke barabar to banda nikalo kaam speed ka or 
            //agla daalo
            if(currentTeam.size()==k){
             // remove slowest engineer from out current team
                Engineer slowengineer =currentTeam.remove();
                
                //now we remove the slow engineer speed from total speed
                TeamSpeed -=slowengineer.speed;
                
            }
            //hire the new engineer to the team
            currentTeam.add(val);
            
            //so pickup the new engineer speed and add it to the current team
            TeamSpeed +=val.speed;
            
            //Minimum would be the new hire efficiency
            long performancenew =TeamSpeed*(long)val.efficiency;
            maxPerformance =Math.max(maxPerformance,performancenew);//isme answer hai
                
                
                
        }
        return (int)(maxPerformance %1000000007);
        
    }
}