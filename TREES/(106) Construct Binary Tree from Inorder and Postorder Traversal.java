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
    //psi =post order start
    //psed =post order end 
    //isi =inorder start
    //isd =inorder end
  public static TreeNode buildTree(int[] postorder ,int psi ,int ped ,int[] inorder ,int isi ,int isd){
      if(isi>isd){
          return null;
      }
      
      TreeNode node =new TreeNode(postorder[ped]);
      int idx =isi;
      while(inorder[idx]!=postorder[ped]){
          idx++;
      }
      int count =idx-isi;
      node.left =buildTree(postorder ,psi ,psi+count-1,inorder ,isi ,idx-1);
      node.right =buildTree(postorder ,psi+count ,ped-1 ,inorder ,idx+1 ,isd);
      return node;

  }


 public TreeNode buildTree(int[] inorder, int[] postorder) {
 int n =postorder.length; 
                return buildTree(postorder ,0,n-1 ,inorder ,0,n-1);
 }
}