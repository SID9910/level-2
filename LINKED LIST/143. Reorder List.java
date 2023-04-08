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
    //     reverse list pointer
          public ListNode reverseList(ListNode head) {
            if(head ==null || head.next ==null) 
                return head;
            ListNode prev=null , curr =head;
            while(curr!=null){
                ListNode frw=curr.next;
                curr.next=prev;
                prev=curr;
                curr=frw;
            }
            return prev;
        }
        
    //     midnode 
          public ListNode middleNode(ListNode head) {
          if(head ==null || head.next ==null){
              return head;
          }
            ListNode slow =head ,fast =head;
            
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
              
        }
        public void reorderList(ListNode head) {
            ListNode midnode =middleNode(head);
            ListNode nhead=midnode.next;
            midnode.next =null;
            nhead=reverseList(nhead);
            ListNode c1=head , c2=nhead;
            while(c2!=null){
                ListNode f1=c1.next ,f2=c2.next;
                c1.next=c2;
                c2.next=f1;
                c1=f1;
                c2=f2;
            }
            
        }
    }