/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   
    public int size(ListNode node){
        int length =0;
        while(node!=null){
            node=node.next;
            length++;
        }
        return length;
    }
    
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA =size(headA);
        int lenB =size(headB);
        
        ListNode tempA =headA;
        ListNode tempB=headB;
        int gap =Math.abs(lenA-lenB);
        if(lenA>lenB){
            for(int i=0;i<gap;i++){
                tempA=tempA.next;
            }
            
        }else {
             for(int i=0;i<gap;i++){
                tempB=tempB.next;
            }
        }
        while(tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA;
        
        
    }
}