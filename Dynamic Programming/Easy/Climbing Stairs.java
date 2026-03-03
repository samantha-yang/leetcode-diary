// Recursive solution
class Solution {
    public int climbStairs(int n) {
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n) {
            // If i == n, return 1 since one valid way
            if (i == n) {
                return 1;
            // Else return 0 since i > n
            } else {
                return 0;
            }
        // Recurively compute how many ways to take 1 step and 2 steps
        // Return the sum of both choices
        }
        return dfs(n, i + 1) + dfs(n, i + 2);
    }
}

// Intuition: We want to explore all cases and backtrack, so use dfs

// DP Solution
public class Solution {
    public int climbStairs(int n) {

        // Current = ways to reach current stair
        // Previous = ways to reach previous stair
        // Both start at 1 because there is only 1 way to reach stair 0 and stair 1
        int current = 1, previous = 1;

        // We do (n - 1) because we already start with the first stair counted
        for (int i = 0; i < n - 1; i++) {

            // Save current before we overwrite it
            int temp = current;

            // Current stair = current + previous (fibonacci)
            current = current + previous;

            // Previous stair slides forward to where current used to be
            previous = temp;
        }

        // Current now holds the total ways to reach stair n
        return current;
    }
}
