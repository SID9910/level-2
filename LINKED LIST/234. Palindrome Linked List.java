/**

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