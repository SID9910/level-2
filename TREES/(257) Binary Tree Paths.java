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
    public List<String> binaryTreePaths(TreeNode root) {
     List<String> answer = new ArrayList<String>();
     searchBT(root, "", answer);
     return answer;
 }
 private void searchBT(TreeNode root, String path, List<String> answer) {
     if(root==null){
         return ;
     }
     if (root.left == null && root.right == null) answer.add(path + root.val);
      searchBT(root.left, path + root.val + "->", answer);
      searchBT(root.right, path + root.val + "->", answer);
 }
 }