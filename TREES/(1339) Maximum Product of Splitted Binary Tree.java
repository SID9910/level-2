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
     
    long max=0;
public int maxProduct(TreeNode root) {
           if(root == null) return 0;
     max =root.val;
    long sum =totalsum(root);
   subtreesum(root ,sum);

   return (int)(max % (Math.pow(10,9)+7));
   }

   

   public long subtreesum(TreeNode node ,long sum){
       if(node==null){
           return 0;
       }
       long left =subtreesum(node.left ,sum);
       long right =subtreesum(node.right,sum);
   long done =left+right+node.val;
       
       long mat =(sum-done)*done;
       max =Math.max(max ,mat); 
       
           
       return done;
       
   }
    public long totalsum(TreeNode node){
       if(node==null){
           return 0;
       }
       long left =totalsum(node.left);
       long  right =totalsum(node.right);
       return node.val+left+right;
   }
   
 
}