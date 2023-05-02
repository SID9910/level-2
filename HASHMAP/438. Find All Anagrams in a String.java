class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
    
        ArrayList<Integer> list = new ArrayList<>();
       
        
        if(s.length()<p.length()){
            return list;
        }
        int[] map2 = new int[26];
         
        for(int i=0;i<p.length();i++){
            char ch =p.charAt(i);
            map2[ch-'a']++;//ye compare ke ley hai freq map
            
        }
        int[] map1 = new int[26];
        for(int i=0;i<p.length();i++){
            char ch =s.charAt(i); //s taak ke daal do
            map1[ch-'a']++;
        }
        
        if(areAnagram(map1,map2)==true){
            list.add(0); //0 index added
        }
        int i=p.length();
        int j=0;
        
        while(i<s.length()){
            char ch1 = s.charAt(i);
            map1[ch1-'a']++;
             char ch2 =s.charAt(j);
        if(map1[ch2-'a']>0){
            map1[ch2-'a']--;
        }
        
        if(areAnagram(map1,map2)==true){
            list.add(j+1);
        }
        j++;
        i++;
        }
       
        
        return list;
        
        
    }
    public boolean areAnagram(int[] map1 ,int[] map2){
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i]){
                return false;
            }
        }
        return true;
    }
}