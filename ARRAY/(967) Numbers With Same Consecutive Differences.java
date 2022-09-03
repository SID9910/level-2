class Solution {
    //code se understand karna thoda tough //dfs
    //tc -o(n*2n) and space=o(n*2n)
    public int[] numsSameConsecDiff(int n, int k) {
     //agar bss eek digit ka number hua to 1-9 saare he honge
        //and usme k matter nhi karega
        if(n==1){
         return new int[]{0,1,2,3,4,5,6,7,8,9};
         }   
        //result isme store hoga
        List<Integer> results = new ArrayList<Integer>();
        
        //saare number ke sath check karega
        //eek loop dry run karke aaega sam,aj
        //isme aagr 3 number hai to niche do jaenge 
        for(int nums =1;nums<10;nums++){
            dfs(n-1,nums,k,results);
        }
        
        //to convert list into array
         int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++)
            res[i] = results.get(i);
        return res;
        
    }
    
    public void dfs(int n,int num , int k , List<Integer> results){
        //terminating condition
        if(n==0){
            results.add(num);
            return ;
        }
        
        //condition 
        Integer lastdigit = num%10;
        //k aagr zero hua to kuch nhi karenge
        if( k >0 && lastdigit+k<10){
            dfs(n-1,num*10 +lastdigit+k,k,results);
        }
        
         if(lastdigit-k>=0){
            dfs(n-1,num*10 +lastdigit-k,k,results);
        }
    }
}