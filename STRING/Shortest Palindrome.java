import java.io.*;
import java.util.*;

public class Main {

  public static String solution(String str){
    String s =str+"$"+ new StringBuilder(str).reverse().toString();//pepcoding$gindocpep
  
    int[] lps =new int[s.length()];
      int len=0;
    int i=1;
    while(i<s.length()){
if(s.charAt(i)==s.charAt(len)){
    len++;
    lps[i]=len;
     i++;
    
}else{
    if(len>0){
        len =lps[len-1];
    }else{
        lps[i]=0;
        i++;
    }
}        
    }
    
    int ppl =lps[s.length()-1];
    String right=str.substring(ppl);
    return  new StringBuilder(right).reverse().toString()+str;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

}