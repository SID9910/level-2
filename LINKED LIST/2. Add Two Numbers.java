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
    
    //tc-o(n) space-0(1)
    public ListNode addTwoNumbers(ListNode c1, ListNode c2) {
        if(c1==null || c2==null){
            return c1!=null ?c1:c2;
        }
        
        ListNode head = new ListNode(-1);
        ListNode itr =head;
        int carry=0;
        while(c1!=null || c2!=null ||carry!=0){
            int sum =carry+(c1!=null?c1.val:0)+(c2!=null?c2.val:0);
            int digit =sum%10;
            carry=sum/10;
            
            itr.next =new ListNode(digit);
            itr=itr.next;
            if(c1!=null){
                c1=c1.next;
            }
            if(c2!=null){
                c2=c2.next;
            }
        }
        return head.next;
        
        
        
    }
}