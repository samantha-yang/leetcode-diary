public class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the current node is null, return 0
        if (root == null) {
            return 0;
        }
        
        // Recursive case: compute depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the max depth of the two subtrees, plus one to account for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}