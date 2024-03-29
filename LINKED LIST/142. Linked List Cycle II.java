/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

//ye its done
    public ListNode detectCycle(ListNode head) {
      
         if(head==null || head.next==null){
             return null;
         }
        ListNode slow =head;
        ListNode fast =head;
        
        while(fast!=null && fast.next!=null){
            fast =fast.next.next;
            slow =slow.next;
        
        if(slow==fast){
            break;
        }
        }
        if(slow!=fast){
            return null;
        }
        slow =head;
        fast =fast;
        while(slow!=fast){
            slow =slow.next;
            fast =fast.next;
        }
        return slow;
    
    
    }
}