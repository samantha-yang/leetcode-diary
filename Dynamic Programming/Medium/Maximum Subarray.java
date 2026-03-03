public class Solution {
    public int maxSubArray(int[] nums) {
        // Clone the nums array
        int[] dp = nums.clone();
        // Go through the nums, starting with index 1 to compare to prev
        for (int i = 1; i < nums.length; i++) {
            // Start fresh at current num, or extend the best prev sum
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int maxSum = dp[0];
        // Scan dp for the largest sum
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}