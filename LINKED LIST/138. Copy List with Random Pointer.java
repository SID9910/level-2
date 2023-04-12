/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //approach -1 (hashMap) extra space
//     public Node copyRandomList(Node head) {
        
//     HashMap<Node, Node> map = new HashMap<Node, Node>();
    
    
//     Node curr= head;
//         Node nhead =new Node(-1);
//         Node prev = nhead;
//     while(curr!= null){
//         Node node = new Node(curr.val);
//         prev.next =node;
//         map.put(curr, node);
//         prev = prev.next;
//         curr =curr.next;
//     }
//         nhead =nhead.next;
    
//     Node c1 =head;
//         Node c2 =nhead;
//     while(c1!= null){
     
//         c2.random = (c1.random!=null) ? map.get(c1.random):null;
//         c1=c1.next;
//         c2=c2.next;
//     }
    
//     return nhead;   
//     }
    
    //approach -2 without extra space
    
    //attach node
    public void attachcopies(Node head){
        Node curr =head;
        while(curr!=null){
            Node forw =curr.next;
            Node node = new Node(curr.val);
            
            curr.next =node;
            node.next =forw;
            curr =forw;
        }
    }
    //copy of attach random
    public void attachrandom(Node head){
        Node curr= head;
        while(curr!=null){
            Node rand =curr.random;
            if(rand!=null){
                curr.next.random =rand.next;
                
            }
            curr =curr.next.next;
        }
    }
    
    //detech of copies 
      public Node attachlist(Node head){
      
          Node dummy = new Node(-1);
          Node prev =dummy;
          Node curr =head;
          while(curr!=null){
              prev.next =curr.next;
              curr.next =curr.next.next;
              prev =prev.next;
              curr=curr.next;
              
          }
          return dummy.next;
      }
    
    //main'
      public Node copyRandomList(Node head) {
      
          attachcopies(head); 
          attachrandom(head);
          return attachlist(head);
    }
    
}