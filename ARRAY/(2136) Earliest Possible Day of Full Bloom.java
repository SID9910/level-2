class Solution {
    //greedy approach
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
     int n =plantTime.length;
        int mat [][] = new int[n][2];
       for(int i=0;i<n;i++){
           mat[i][0]=plantTime[i];
           mat[i][1]=growTime[i];
       } 
        //sort on the basis of growth
      Arrays.sort(mat,(a,b) -> b[1]-a[1]);
        
        
            System.out.println();
        
        
        int bloomday =0;//bloom time start main zero index ban lo
        int seedplantingDay =0;//seeding time manlo 0 day pe seed lga dea jaise 
        for(int i=0;i<n;i++){
            int ptime =mat[i][0];
            int gtime =mat[i][1];
            
            bloomday =Math.max(bloomday ,seedplantingDay+ptime+gtime);
            seedplantingDay =seedplantingDay+ptime;//itne time pe seed lagenge
        }
        
        return bloomday;//isme days aajenge
    }
}