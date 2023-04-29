class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
     HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val:deck){
            map.put(val,map.getOrDefault(val,0)+1);
            
        }
        int counter =0;
        int gcd=1; //one to hota hai sabka
 
     for(int key:map.keySet()){
         if(counter==0){
             gcd =map.get(key);
         }else{
             int num=map.get(key);
             gcd =getgcd(num ,gcd);
         }
         counter++;
     }
        
    return gcd>=2;
    }
    
    public int getgcd(int n1,int n2){
        while(n1%n2!=0){
            int rem=n1%n2;
            n1=n2;
            n2=rem;
        }
        int gcd =n2;
        return gcd;
    }
}