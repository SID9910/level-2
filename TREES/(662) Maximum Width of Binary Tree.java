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

//aacHA sawal hai bss thoda stack or queu ke operations or dekhunga
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index){
        this.node=node;
        this.index=index;
    }
}
     
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max=0;
        Deque<Pair> que=new LinkedList<>();
        que.add(new Pair(root, 0));
        while(que.size()>0){
            int count=que.size();
            int firstindex=que.peekFirst().index;//first index
            int secondindex=que.peekLast().index;//last index
            max=Math.max(max, secondindex-firstindex+1);
            for(int i=0;i<count;i++){
                Pair current=que.remove();
                TreeNode currentNode=current.node; //current node
                int indexing=current.index;//current node index
                if(currentNode.left!=null){
                    que.add(new Pair(currentNode.left, 2*indexing+1));
                }
                if(currentNode.right!=null){
                    que.add(new Pair(currentNode.right, 2*indexing+2));
                }
            }
        }
        return max;
    }
}
