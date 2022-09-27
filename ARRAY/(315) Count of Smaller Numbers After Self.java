class Solution {
    
    //store all the count of smaller element
    int[] res;
    
    //store indx and val
    class Pair{
        int idx;
        int val;
        Pair(int idx ,int val){
            this.idx =idx;
            this.val=val;
        }
    }
    
       public List<Integer> countSmaller(int[] nums) {
        Pair[] pairs =new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pairs[i]= new Pair(i ,nums[i]);
        }
        res = new int[pairs.length];
//call merge sort
           mergesort(pairs, 0,pairs.length-1);
        ArrayList<Integer> ans  = new ArrayList<>();
        for(int val:res){
            ans.add(val);
        }
        
        
        return ans; //arraylist return
    }
    
    //mergesort
       Pair[] mergesort(Pair[] pairs,  int left, int right){
        if(left==right){ 
            Pair[] base = new Pair[1];
              base[0]= new Pair(left, pairs[left].val);
            return base;
        }
        int mid =(left+right)/2;
        
        Pair[] left1 =mergesort(pairs, left,mid);
        Pair[] right1 =mergesort(pairs, mid+1,right);
        Pair[] merge2 =merge2sort(left1 ,right1);
        return merge2;
    }
    
   //merge 2 sort 
   public  Pair[] merge2sort(Pair[] left ,Pair[] right){
        Pair[] ret =new Pair[left.length+right.length];
        
    
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i].val>right[j].val){
                ret[k]=left[i];
        res[left[i].idx] += (right.length-j);  //main kaam bss right ka count le lo
                                               //jaab left right se bda ho and store in right
                i++;
                k++;   
            }else{
                ret[k]=right[j];
                j++;
                k++;
            }
        }
       while(i<left.length){
           ret[k]=left[i];
           i++;
       k++;
       }
       while(j<right.length){
           ret[k]=right[j];
           j++;
           k++;
       }
        return ret; //ye decreasing order main sort hoga
        
    }
 
 
}