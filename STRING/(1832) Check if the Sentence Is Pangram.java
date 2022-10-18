class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];

       

        for(char ch:sentence.toCharArray()){

            arr[ch-'a']++;


            }
       boolean val=true;
for(int i=0;i<arr.length;i++){
    if(arr[i]==0){
        return false;
    }
}
        


        

            
      return true;
        }

        
    }