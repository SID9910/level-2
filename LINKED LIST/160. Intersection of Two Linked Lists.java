/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //aprroach-difference approach
 //     public int size(ListNode node){
 //         int length =0;
 //         while(node!=null){
 //             node=node.next;
 //             length++;
 //         }
 //         return length;
 //     }
     
     
 //     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 //         int lenA =size(headA);
 //         int lenB =size(headB);
         
 //         ListNode tempA =headA;
 //         ListNode tempB=headB;
 //         int gap =Math.abs(lenA-lenB);
 //         if(lenA>lenB){
 //             for(int i=0;i<gap;i++){
 //                 tempA=tempA.next;
 //             }
             
 //         }else {
 //              for(int i=0;i<gap;i++){
 //                 tempB=tempB.next;
 //             }
 //         }
 //         while(tempA!=tempB){
 //             tempA=tempA.next;
 //             tempB=tempB.next;
 //         }
 //         return tempA;
         
         
 //     }
     
     //flloyd cycle approach
     public ListNode flloydcycle(ListNode head){
         if(head==null || head.next==null){
             return null;
         }
         
         ListNode slow =head;
         ListNode fast =head;
         while(fast!=null && fast.next!=null){
             slow =slow.next;
             fast=fast.next.next;
           if(slow==fast){
               break;
           }
             
         }
         if(slow!=fast){
             return null;
         }
         
         slow=head;
         fast=fast;
         while(slow!=fast){
             slow=slow.next;
             fast=fast.next;
         }
         return slow;
         
     }
       
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
      if(headA==null || headB==null){
          return null;
      }
     ListNode tail =headA;
         while(tail.next!=null){
             tail=tail.next;
         }
         tail.next=headB;
         ListNode ans = flloydcycle(headA);
         tail.next=null;
         return ans;
         
     }
 }