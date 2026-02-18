public class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the current node is null, return null
        if (root == null) {
            return null;
        }

        // Swap the left and right children of the currr node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}