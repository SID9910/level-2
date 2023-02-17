/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min=Integer.MAX_VALUE;
   int prev;
   public int minDiffInBST(TreeNode root) {
        prev=-1;
       inorder(root);
       return min;
   }
   public void inorder(TreeNode node){
       if(node==null){
           return;
       }
       inorder(node.left);
       if(prev!=-1){
           min=Math.min(min,node.val-prev);
        
       } 
              prev=node.val;  
       inorder(node.right);
       
   
   }
}