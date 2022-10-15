class Solution {
    public String largestNumber(int[] nums) {
        //convert into string
      String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=nums[i]+"";
        }
        //sort on the basis so that large values come first
        Arrays.sort(str,(a,b)->{
            String case1 =a+b;
            String case2 =b+a;
           return case2.compareTo(case1); //baade vale ko pehle rakhega
        });
        
        //if starting zero encounter then return 0
        if(str[0].equals("0")){
            return "0";
        }
        
        //then append to stringbuilder
        StringBuilder sb = new StringBuilder();
        for(String val:str){
            sb.append(val);
        }
        return sb.toString();
    }
}