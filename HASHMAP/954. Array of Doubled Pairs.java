class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val:arr){
          map.put(val ,map.getOrDefault(val,0)+1);    
        }
        
        Arrays.sort(arr);
        
        for(int val:arr){
            
            if(val!=0 && map.containsKey(val) && map.containsKey(2*val)){
                
                if(map.getOrDefault(val,0)>1){
                    map.put(val,map.getOrDefault(val,0)-1);
                }else{
                    //eek frequency ho uda do
                    map.remove(val);
                }
                
                 if(map.getOrDefault(2*val,0)>1){
                    map.put(2*val,map.getOrDefault(2*val,0)-1);
                }else{
                    //eek frequency ho uda do
                    map.remove(2*val);
                }
            }
            
        }
        if(map.size()==0){
            return true;
        }
        //kyuki val!=0 uper hum kar rahe hai zero ko nhi le rahe 
        //and vo hua aaagar akela to pakka even he hoga kyuki question main 
        //dea hua hai so true karenge
        else if(map.size() ==1 && map.containsKey(0)){
            return true;
        }else{
            return false;
        }
        
    }
}