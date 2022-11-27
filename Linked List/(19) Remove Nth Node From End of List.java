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
    //class question kth from last
   public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // move fast pointer to the n + 1 element
        // now the distance between slow and fast pointer is n nodes
        for (int i = 0; i < n; i++) fast = fast.next;
        // if fast reached the end, we need to remove the first element
        // e.g. head = [1], n = 1 
        if (fast == null) return head.next;
        // move both pointers at the same time until 
        // the fast pointer reaches the end
       
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow pointer will be pointing to the node before the one to be removed
        // then we update the next node of the slow pointer
        slow.next = slow.next.next; //bss ye logic extra hai
        return head; //return head
    }
}