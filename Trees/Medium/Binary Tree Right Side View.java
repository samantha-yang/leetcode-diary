/*
 * Problem:  (LC 199) Binary Tree Right Side View
 * Pattern:  Tree Traversal
 * Technique: DFS (preorder, right-before-left)
 * Time: O(n) - visit every node once
 * Space: O(h) - auxiliary, where h is the height of the tree (recursion call stack)
 *               O(n) worst case for a skewed tree, O(log n) for a balanced tree
 *
 * Key insight: By traversing right before left and only recording a value
 *              the first time we reach each depth, the first node seen at
 *              each level is always the rightmost visible one.
 *
 * Pitfall: Don't skip the left traversal. A left child may be the only
 *          node at its depth if the right subtree doesn't extend that far.
 */

public class Solution {
    // Stores the rightmost visible node value at each depth level
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // If we haven't recorded a value for this depth yet, this is the first
        // rightmost node seen at this level, so add it to result
        if (result.size() == depth) {
            result.add(node.val);
        }

        // Traverse right first so the rightmost node at each depth is always visited first
        dfs(node.right, depth + 1);
        // Traverse left second as fallback
        dfs(node.left, depth + 1);
    }
}