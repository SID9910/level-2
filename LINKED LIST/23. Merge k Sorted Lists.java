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
//jo
class Solution {
    //merge sort approach 
 //      public ListNode mergeKLists(ListNode[] lists) {
 //         if(lists.length==0){
 //             return null;
 //         }
 //          return mergeklist(lists,0,lists.length-1);
 //     } 
     
 //     //merge two sorted list
 //       public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 //         if (l1 == null) return l2;
 //     if (l2 == null) return l1;
 //     ListNode temp = new ListNode(0);
 //     ListNode current = temp; //
 //     while (l1 != null && l2 != null) {
 //         if (l1.val < l2.val) {
 //             current.next = l1;
 //             current = l1;
 //             l1 = l1.next;
 //         } else {
 //             current.next = l2;
 //             current = l2;
 //             l2 = l2.next;
 //         }
 //     }
 
 //     if (l1 != null) current.next = l1;
 //     if (l2 != null) current.next = l2;
 //     return temp.next;   
 //     }
     
 //     public ListNode mergeklist(ListNode[] lists ,int start ,int end){
 //         if(start>end){
 //             return null;
 //         }
 //         if(start==end){
 //             return lists[start];
 //         }
 //         int mid =(start+end)/2;
         
 //         ListNode l1 =mergeklist(lists,start ,mid);
 //         ListNode l2 =mergeklist(lists,mid+1 ,end);
       
 //          return mergeTwoLists(l1 ,l2);
 //     }
     
     //priorityQueue approach
        public ListNode mergeKLists(ListNode[] lists) {
        
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) ->{
                return a.val-b.val;
            });
            
            for(ListNode l1 :lists){
                if(l1!=null){
                    pq.add(l1);
                }
            }
                ListNode dummy = new ListNode(-1);
                ListNode prev =dummy;
                while(pq.size()!=0){
                    ListNode node =pq.remove();
                         prev.next =node;
                    prev =prev.next;
                    node =node.next;
                    if(node!=null){
                        pq.add(node);
                    }
                    
                }
            return dummy.next;
            }
     }
 
    
 