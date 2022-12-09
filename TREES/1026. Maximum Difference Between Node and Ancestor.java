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
    
    public int find(TreeNode root ,int max ,int min){
        if(root==null){
            return max-min;
        }
        max =Math.max(root.val ,max);
        min =Math.min(root.val ,min);
        return Math.max(find(root.left ,max ,min) ,find(root.right ,max ,min));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        int maxvalue =Integer.MIN_VALUE;
        int minvalue =Integer.MAX_VALUE;
        return find(root ,maxvalue ,minvalue);
        
    }
}