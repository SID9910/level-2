class Solution {
    //normal merge sort apporoach
    //tc=0(n+m)
    //space=0(n+m)
    //brute ke samaj lo
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] res = new int[nums1.length+nums2.length];
//         int i=0;
//         int j=0;
//         int k=0;
//         while(i<nums1.length && j<nums2.length){
//             if(nums1[i]>nums2[j]){
//                 res[k]=nums2[j];
//                 j++;
//                 k++;
//             }else {
//                 res[k]=nums1[i];
//             i++;
//                 k++;
//             }
//         }
//         while(i<nums1.length){
//             res[k]=nums1[i];
//             i++;
//             k++;
//         }
        
//         while(j<nums2.length){
//             res[k]=nums2[j];
//             j++;
//             k++;
//         }
//         double median =0.0;
//         int mid =res.length/2;
//         if(res.length%2==1){
//             median=res[mid];
//         }else{
//             median =(res[mid]+res[mid-1])/2.0;
            
//         }
//         return median;
//     }
    //optimised approach
    //tc=o(log(m+n))
    //space =o(1)
//binary search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //vaise hum nums1 ko chota man kar chal rahe hai
        //isley aagr if in case nums1 bada hua then hum 
        //swap kar denge 
        
       if(nums1.length >nums2.length){
           int[] temp =nums1;
           nums1=nums2;
           nums2=temp;
       }
        int lo =0;
        int hi =nums1.length;
        //total hum isley nikal raheh hai b ke ley aage use hoga
        int total =nums1.length+nums2.length;
        while(lo<=hi){
            //left ke saare honge inme
            int aleft =(lo+hi)/2;
            int bleft =(total+1)/2-aleft;
            
            //aagr bich main zero hua then min infinity
            //nhi to val
            int aleftmin1 =(aleft==0)?Integer.MIN_VALUE:nums1[aleft-1];
            //aagr last per pohocha then use max infinity
            int a1 =(aleft==nums1.length)?Integer.MAX_VALUE:nums1[aleft];
             //aagr bich main zero hua then min infinity
            //nhi to val
            int bleftmin1 =(bleft==0)?Integer.MIN_VALUE:nums2[bleft-1];
             //aagr last per pohocha then use max infinity
            int b1 =(bleft==nums2.length)?Integer.MAX_VALUE:nums2[bleft];
            //valid segregation
            //aagr ye hua then mtlb ans mill gya
            if(aleftmin1<=b1 && bleftmin1<=a1){
                double median =0.0;
           //for even cases
                if(total%2 == 0){
                    int lmax =Math.max(aleftmin1,bleftmin1);
                    int rmin =Math.min(a1,b1);
                    median =(lmax+rmin)/2.0;
                }else{ //for odd cases
                    int lmax=Math.max(aleftmin1,bleftmin1);
                    median =lmax;
                }
                return median;
                
                //aagr case uper violet hua taab  karenge
            }else if(aleftmin1>b1){
                hi=aleft-1;
            }else{
                lo =aleft+1;
            }
            
        }
        return 0;
    }
}