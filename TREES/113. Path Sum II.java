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
    //dubara aaonga iss sawal per
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
  List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    pathSum(ans, path, root, targetSum);
    return ans;
}

private void pathSum(List<List<Integer>> ans, List<Integer> path,
		TreeNode root, int sum) {
	if (root == null)
		return;
	List<Integer> newPath = new ArrayList<>(path);
	newPath.add(root.val);
	if (root.left == null && root.right == null && root.val == sum) {
		ans.add(newPath);
		return;
	}
	pathSum(ans, newPath, root.left, sum - root.val);
	pathSum(ans, newPath, root.right, sum - root.val);
}
}