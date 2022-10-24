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
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if(root == null){
          TreeNode temp = new TreeNode(val , null , null);
          return temp;
      }  
     if(root.val>val){
         root.left = insertIntoBST(root.left,val);
         return root;
     }  else if(root.val<val){
         root.right = insertIntoBST( root.right,val);
          return root;
     }
        
        return root;
    }
}