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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avlist = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null){
            return avlist;
        }
        que.add(root);
        while(que.size()>0){
            int n = que.size();
            double sum =0.0;
            for(int i=0;i<n;i++){
                TreeNode node = que.remove();
                sum+=node.val;
                if(node.left!=null){
                 que.add(node.left);                   
                }
                if(node.right!=null){
                    que.add(node.right);
                }
                
            }
            avlist.add(sum/n);
        }
        return avlist;
      
    }
}

//
