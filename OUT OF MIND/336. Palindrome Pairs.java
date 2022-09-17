class Solution {
    //tries
    //tough
public  boolean isPalindrome(String s) {
int left =0;
    int right =s.length()-1;
    boolean flag =true;
    while(left<=right){
if (s.charAt(left) != s.charAt(right)){
flag =false;
    break;
    }
    left++;
    right--;
    }
return flag;    
}


public List<List<Integer>> palindromePairs(String[] words) {
    int n = words.length;
    List<List<Integer>> pairs = new LinkedList<>();
       if (words == null) return pairs;
HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; ++ i)
    {
        
        StringBuilder str= new StringBuilder(words[i]);
        String reverseStr = str.reverse().toString();
                map.put(reverseStr, i);
    }
    
    for(int i =0;i<n;i++)
    {
        for(int j=0;j<=words[i].length();j++)
        {
            String str1=words[i].substring(0,j);
            String str2 = words[i].substring(j);
if(map.containsKey(str1) && isPalindrome(str2) && map.get(str1) != i) {
pairs.add(Arrays.asList(new Integer[]{ i,map.get(str1)}));
}
if(!str1.isEmpty() && map.containsKey(str2) && isPalindrome(str1) && map.get(str2) != i) {
pairs.add(Arrays.asList(new Integer[]{map.get(str2), i}));
}
}
}

    return pairs;
}
}