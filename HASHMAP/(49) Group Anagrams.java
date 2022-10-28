class Solution {
    //learning while doing question
    public List<List<String>> groupAnagrams(String[] strs) {
     HashMap<HashMap<Character ,Integer>,ArrayList<String>>  bmap =new HashMap<>();
        for(String str: strs){
            HashMap<Character,Integer> fmap = new HashMap<>();
            for(int i=0;i<str.length();i++){
                char ch =str.charAt(i);
                fmap.put(ch ,fmap.getOrDefault(ch,0)+1);
            }
            if(bmap.containsKey(fmap)==false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(fmap,list);
            }else{
                //ye jo paadi hai uski list mian jakar add karega
                ArrayList<String> list =bmap.get(fmap); 
                list.add(str);
            }
        }
        //res list main daal do
        List<List<String>> res = new ArrayList<>();
        for(ArrayList<String> val: bmap.values()){
            res.add(val);
        }
        return res;
    }
}