class Solution {
    public String orderlyQueue(String s, int k) {
    if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        //normal sorting 
         if(k>1) {
            char [] convertedToArray = s.toCharArray();
            Arrays.sort(convertedToArray);
            return new String(convertedToArray);
        }else {
            // for k==1 
            String answer = s;
            
            for (int i=0; i<length; i++) {
                String rotatedOneCharacter = s.substring(i) + s.substring(0, i);
                if (answer.compareTo(rotatedOneCharacter) > 0) {
                    answer = rotatedOneCharacter;
                }
            }
            return answer;
        }
    }
}