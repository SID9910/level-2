class Solution {
    //pure kmp logic hai
    public String longestPrefix(String s) {
    
    int[] lps = new int[s.length()];
      lps[0]=0; 
        int i=1;
        int len=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                
                i++;
            }else{
                if(len>0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        //bss last index main ho
        //vo fetch karlo
        //and utni substring lelo
        int k =lps[s.length()-1]; 
    
    return s.substring(0,k);
    }
    
   
         
    }
    
