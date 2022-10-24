class Solution {
    //dubara 
    public int maxLength(List<String> arr) {
     List<String> ans = new ArrayList<>();
        int max =0;
        ans.add("");
        for(String str:arr){
            if(!checkuniqueString(str)){
                continue;
            }
            List<String> newans =new ArrayList<>();
            for(String candidate: ans){
                String temp =candidate + str ;
            if(checkuniqueString(temp)){
                newans.add(temp);
                max =Math.max(max ,temp.length());
            }    
            }
            ans.addAll(newans);
    }
        return max;
}
    
    //unique string bateaga
    private boolean checkuniqueString( String str){
        if(str.length()>26){
            return false;
        }
        int[] freq = new int[26];
        char[] arr = str.toCharArray();
        for(char ch :arr){
            freq[ch-'a']++;
            if(freq[ch-'a']>1){
                return false;
            }
        }
        return true;
    }
}