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
    // kth from last same variety hai
    //indexing 0 se nhi hai so dry run se pta chalega fast and slow ka motion
   public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
    
        for (int i = 0; i < n; i++){
            
            fast = fast.next; 
        }
 
      
        while (fast.next !=null) {
            fast = fast.next;
            slow = slow.next;
        }
       
        slow.next = slow.next.next;
        return head;
    }
}