public class Solution {

    
    //tc-0(n) space-0(1)
    public ListNode oddEvenList(ListNode head) {
      
		if(head==null) return head;
		
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; //means pointing towards even
        
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    
    }
}