//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
      public static class tpair{
         Node node ;
         int h1;
         tpair(Node node , int h1){
             this.node =node;
             this.h1 =h1;
         }
     }
     public static void twidth(Node node , int h1 ,int[] arr){
         if(node ==null){
             return ;
         }
         arr[0]=Math.min(arr[0],h1);
         arr[1]=Math.max(arr[1],h1);
         twidth(node.left,h1-1 ,arr);
         twidth(node.right ,h1+1 ,arr);
     }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
         if(root==null){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int[] minmax =new int[2];
        twidth(root , 0, minmax);
        int len =minmax[1]-minmax[0]+1;
        for(int i=0;i<len;i++){
            ans.add(0);
        }
        Queue<tpair> que = new LinkedList<>();
        que.add(new tpair(root,Math.abs(minmax[0])));
        
        while(que.size()>0){
            int size =que.size();
            while(size-->0){
                tpair rp =que.remove();
               
            Node node =rp.node;
            int  h1 =rp.h1;
         //ye last vala fetch karega index kyuki udher null hoga
         //bss eek bar he set karega    
          
           ans.set(h1,node.data);
      
            if(node.left!=null){
                que.add(new tpair(node.left ,h1-1));
            }
                    if(node.right!=null){
                que.add(new tpair(node.right ,h1+1));
            }
            
            }
        }
        return ans;
 
    }
}