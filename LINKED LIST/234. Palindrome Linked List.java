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
  

    private boolean isPalindromeHelper(ListNode right){
        if(right == null){
            return true;
        }
        boolean rres = isPalindromeHelper(right.next);
        if(rres == false){
            return false;
        }else if(pleft.val != right.val){
            return false;
        }else{
            pleft = pleft.next;
            return true;
        }
    }
    
    
    ListNode pleft;
    public boolean isPalindrome(ListNode head) {
        pleft =head;
        return isPalindromeHelper(head);
    }
}