class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%2!=0){
            return n*2;
        }else{
            int jem =n/2;
            return jem*2;
        }
    }
}