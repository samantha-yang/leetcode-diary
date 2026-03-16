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

public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start validation with the widest possible valid range
        // Using Long bounds (instead of Integer) to handle edge cases
        // where node values are Integer.MIN_VALUE or Integer.MAX_VALUE
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Recursively validates each node by passing down an allowed (left, right) range.
    // Every node must satisfy: left < node.val < right
    public boolean valid(TreeNode node, long left, long right) {
        // Base case: null nodes don't violate anything
        if (node == null) {
            return true;
        }

        // Check that this node's value falls strictly within its allowed range
        if (!(left < node.val && node.val < right)) {
            return false;
        }

        // Recurse left:  the left child must be LESS than the current node,
        //                so we tighten the upper bound to node.val
        // Recurse right: the right child must be GREATER than the current node,
        //                so we tighten the lower bound to node.val
        return valid(node.left, left, node.val) &&
               valid(node.right, node.val, right);
    }
}