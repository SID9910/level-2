public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] upd:updates){
            int start =upd[0];
            int end =upd[1];
            int val =upd[2];
        
        res[start]+=val;
   
          //bss ye if ki conditiopn last case ko handle ke ley hai
            if(end+1<res.length){
                res[end+1]-=val;

            }
        }
        for(int i=1;i<res.length;i++){
            res[i]+=res[i-1];
        }
        return res;
    }
}