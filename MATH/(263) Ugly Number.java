// class Solution {
//     public boolean isUgly(int n) {
//         //khali 2,3,5 vale cases lenge //zero se niche ke nhi
//         //aaagr number se chota hai to false 
//         if (n <= 0) {return false;}
//         //2,3,5 ke sath bs 1 kyuki vo apne aap main prime hai
//     if (n == 1) {return true;} //aaagr 1 to return true
        
//         //pehle number ko divide kardo aagr ho gya 
//         //fhir ander usme number per lagao to return lelo fhir
//         //like 14%2 ==0 but it is num/2 =7 this is false then again call
//         //in return statement for further check
//     if (n % 2 == 0) {
//         return isUgly(n/2);
//     }
//     if (n % 3 == 0) {
//         return isUgly(n/3);
//     }
//     if (n % 5 == 0) {
//         return isUgly(n/5);
//     }
//     return false;
//     }
// }

//another approach optimised method
class Solution {
    public boolean isUgly(int n) {
        int flag=0;
        if(n==0)return false;
        while(n!=1 && flag==0){
            flag=1;
             if(n%2==0){
                 n/=2;
                 flag=0;
             }   
             if(n%3==0){
                 n/=3;
                 flag=0;
             }   
             if(n%5==0){
                 n/=5;
                 flag=0;
            }
        }
        if(n==1)return true;
        
        return false;
        
    }
}