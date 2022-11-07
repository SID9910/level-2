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
    //psi-pre start
    //ped -pre end
    //isi -inorder start
    //ied -inorder end
    public static TreeNode buildTree(int[] preorder ,int psi ,int ped ,int[] inorder ,int isi ,int ied ){
        if(isi>ied){
            return null;
        }
        int idx =isi;
        while(inorder[idx]!=preorder[psi]){
            idx++;
        }
        int colse =idx-isi; //nodes on left
        TreeNode node = new TreeNode(preorder[psi]);
        node.left =buildTree(preorder ,psi+1,psi+colse ,inorder,isi ,idx-1);
        node.right =buildTree(preorder ,psi+colse+1 ,ped ,inorder,idx+1 ,ied);
        return node;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n =preorder.length;
        return buildTree(preorder ,0,n-1,inorder ,0,n-1);
    }
}