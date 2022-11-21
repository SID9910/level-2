
class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int depth=0;
        for(Node child :root.children){
            int childdepth =maxDepth(child);
            depth=Math.max(depth,childdepth);
        }
        depth =depth+1;
        return depth;
    }
}