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
    //tc-o(n) space=0(n) hai
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head==null){
           return null;
       } 
        ListNode temp =head;
        
          int cnt=0;
    while(temp!=null){
        cnt++;
        temp=temp.next;
    }
    if(cnt<k){
        return head;
    }
        
        ListNode next =null;
        ListNode prev =null;
        ListNode curr =head;
        
        int count=0;
        
        while(curr!=null && count<k){
         next =curr.next;    
          curr.next =prev;
            prev=curr;
            curr =next;
            count++;
        }
        if(next!=null){
            head.next =reverseKGroup(next ,k);
        }
        return prev;
    }
}