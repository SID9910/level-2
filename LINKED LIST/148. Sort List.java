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
    //done
    public ListNode sortList(ListNode head) {
     if(head==null || head.next==null){
         return head;
     }   
        
        ListNode mid =middleNode(head);
        
        ListNode left =head;
        ListNode right =mid.next;
        mid.next=null;//is se list tut gai do main 
        // and left ,right alag ho gay
        left =sortList(left);
        right =sortList(right);
        
        ListNode result =merge(left ,right);
        
        return result;
        
        
    }
    
    //middle of the linked list
      public ListNode middleNode(ListNode head) {
      if(head ==null || head.next ==null){
          return head;
      }
        ListNode slow =head ,fast =head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       return slow;
    }
    
    //merge
      public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode temp = new ListNode(0);//ye dummy node hai current ke changes saare isme rahenge or start ye 0 se hoga to return temp.next karna kyuki zero nhi involve hai
    ListNode current = temp; 
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            current.next = l1;
            current = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            current = l2;
            l2 = l2.next;
        }
    }

    if (l1 != null) current.next = l1;
    if (l2 != null) current.next = l2;
    return temp.next;   
    }
}