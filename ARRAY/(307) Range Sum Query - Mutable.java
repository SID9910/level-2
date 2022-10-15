class NumArray {
    
    //segment tree formation
    class Node {
        int start;
        int end;
        Node  left;
        Node  right;
        int val;
    }
    Node root;
    
    //segment tree created
    Node construct(int[] nums ,int lo ,int hi){
        
        if(lo ==hi){
            Node node =new Node();
            node.start =node.end =lo;
            node.left=node.right =null;
            node.val=nums[lo];
            return node;
            
        }
        Node node =new Node();
        node.start =lo;
        node.end =hi;
        
        int mid =(lo+hi)/2;
        node.left =construct(nums,lo,mid);
        node.right =construct(nums,mid+1,hi);
        node.val =node.left.val+node.right.val;
        
        return node;
    }
    
  //segment tree formed  

    //update created
    void update(Node node ,int idx ,int val){
    if(node.start==node.end){
        node.val=val;
        return ;
    }
        
        int mid =(node.start+node.end)/2;
        //barabar isley
        //kyuki aagr index  mid ke baharbar hua
        //like 4-7 ka mid 5 to hum udher nhi karna chahte to
        //humme niche 5-5 pe jana hai uske ley left call lga do or niche jao
        if(idx<=mid){
            update(node.left,idx,val);
        }else{
            update(node.right,idx,val);
        }
        //value update kar do tree main
     node.val=node.left.val+node.right.val;
        
}
    
    

    public NumArray(int[] nums) {
        root =construct(nums,0,nums.length-1);//pura segment tree hoga isme 
    }
  
    
    
    public void update(int index, int val) {
        update(root,index,val);
    }
    
    
    //ye sum karega udher taak ka
    //query hamara
    int query(Node node , int querystart ,int queryend){
        if(querystart>node.end || queryend<node.start){
            return 0;
        }else if(node.start>=querystart && node.end<=queryend){
            return node.val;
        }else{
            int lval =query(node.left ,querystart,queryend);
            
            int rval =query(node.right ,querystart,queryend);
            return lval+rval;
        }
        
        
    }
    public int sumRange(int left, int right) {
        return query(root,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */