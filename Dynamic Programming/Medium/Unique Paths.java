/*
 * Problem: Unique Paths (LC 62)
 * Pattern: Grid traversal
 * Technique: Recursive DFS (unoptimized — no memoization)
 * Time: O(2^(m+n)) - each cell branches into 2 recursive calls
 * Space: O(m+n) - auxiliary, call stack depth equals longest path from (0,0) to (m-1,n-1)
 *
 * Key insight: At every cell you can only move right or down, so the total
 * unique paths = paths from the cell to the right + paths from the cell below.
 *
 * Pitfall 1: Confusing rows/columns with moves — an m x n grid requires
 * (m-1) down moves and (n-1) right moves, not m and n. Total moves = m + n - 2.
 *
 * Pitfall 2: Wrong base case — return 1 only at (m-1, n-1), not whenever
 * you hit the last row or column. Triggering early inflates the path count.
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        // Start from the top-left corner (0, 0)
        // Goal is to reach bottom-right corner (m-1, n-1)
        return countPaths(0, 0, m, n);
    }

    public int countPaths(int i, int j, int m, int n) {
        // Base case: reached the bottom-right cell — valid path found
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }

        // Out-of-bounds check: stepped outside the grid — not a valid path
        if (i >= m || j >= n) {
            return 0;
        }

        // Recurse in both allowed directions (right and down),
        // then sum the number of valid paths from each branch
        return countPaths(i, j + 1, m, n) +  // move right
               countPaths(i + 1, j, m, n);   // move down
    }
}