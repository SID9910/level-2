class Solution {
    public String longestCommonPrefix(String[] strs) {
     int minlength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minlength){
                minlength =strs[i].length();
            }
        }
        String result ="";
        
        for(int i=0;i<minlength;i++){
            char character = strs[0].charAt(i);
              int flag =0;
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!= character){
                    flag=1;
                    break;
                }
                
            }
            if(flag==0){
                result+=character;
            }else{
                break;
            }
        }
        if(result.length()==0){
            return "";
        }else{
            return result;
        }
    }
}