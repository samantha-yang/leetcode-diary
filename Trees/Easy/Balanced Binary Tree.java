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
    public boolean isBalanced(TreeNode root) {
        // If tree is empty, it is balanced
        if (root == null) {
            return true;
        }
        
        // Get height of left and right subtrees
        int left = height(root.left);
        int right = height(root.right);
        
        // If the difference at this node is > 1, then it is not balanced
        if (Math.abs(left - right) > 1) {
            return false;
        }

        // Recursively check that both subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        // Base case: a null node has a height of 0
        if (root == null) {
            return 0;
        }

        // Height is 1 (curr node) + the taller of the two subtrees
        return 1 + Math.max(height(root.left), height(root.right));
    }
}