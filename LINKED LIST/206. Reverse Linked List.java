/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //n2 approach not working
 //     public ListNode getidx(int idx,ListNode head){
 //         ListNode temp =head;
 //         for(int i=0;i<idx;i++){
 //             temp=temp.next;
 //         }
 //         return temp;
         
 //     } 
 
 //       public ListNode reverseList(ListNode head) {
 //        //size calculator
 //          ListNode lem =head;
 //          int size=1;
 //           while(lem.next!=null){
 //             size++;
 //             lem=lem.next;
 //         }
      
 //           int li =0;
 //          int ri=size-1;
 //          while(li<ri){
 //              ListNode left =getidx(li ,head);
 //              ListNode right =getidx(ri,head);
 //              int temp =left.val;
 //              left.val=right.val;
 //              right.val=temp;
              
 //              li++;
 //              ri--;
 //          }
 //          return head;
             
 //     }
   
     //iterative approach 0(n)
      public ListNode reverseList(ListNode head) {
      
          ListNode prev=null;
          ListNode curr=head;
          while(curr!=null){
              ListNode next =curr.next;
              curr.next=prev;
              prev=curr;
              curr=next;
              
              
          }
          return prev;
          
          
      
      }
     
     
   
 }