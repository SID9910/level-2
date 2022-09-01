public class Solution {
    public int solve(int[] A) {
        int totaloddsum =0;
        int totalevensum =0;
        
        //isme total sum hoga
        for(int i=0;i<A.length;i++){
            if(i%2==0){
             totalevensum +=A[i];   
            }else{
                totaloddsum +=A[i];
            }
        }
        
        int leftoddsum =0;
        int leftevensum =0;
        int ans =0;//isme hoga count od special elements
        for(int i=0;i<A.length;i++){
            if(i%2==0){
                int rightevensum = totalevensum-leftevensum-A[i];
                int rightoddsum =totaloddsum-leftoddsum;
                //ye balance condition
               if(leftoddsum+rightevensum ==leftevensum+rightoddsum){
                   ans++;
               }
               leftevensum +=A[i];//aage ke ley uska left
            
            }else{
                 int rightevensum = totalevensum-leftevensum;
                int rightoddsum =totaloddsum-leftoddsum-A[i];
                //ye balance condition
               if(leftoddsum+rightevensum ==leftevensum+rightoddsum){
                   ans++;
               }
               leftoddsum +=A[i];//aage ke ley uska left
                
            }
        }
        return ans;
    }
}
