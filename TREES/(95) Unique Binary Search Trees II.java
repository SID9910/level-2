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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    List<TreeNode> helper(int start ,int end){
        if(start>end){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i=start ;i<=end;i++){
            List<TreeNode> left = helper(start ,i-1);
            List<TreeNode> right =helper(i+1,end);
            
            for(TreeNode val:left){
                for(TreeNode val1:right){
                    TreeNode root =new TreeNode(i);
                    root.left =val;
                    root.right =val1;
                    ans.add(root);
                
                }
            }
            
        }
             return ans;    
        
    }
}