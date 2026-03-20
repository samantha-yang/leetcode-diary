/*
 * Problem: Subsets (LC 78)
 * Pattern: Iterative expansion
 * Technique: For each number, copy all existing subsets and add the number to each copy
 * Time: O(n * 2^n) - we process 2^n subsets for each of n numbers
 * Space: O(n * 2^n) - output stores 2^n subsets, each up to size n
 *
 * Key insight: for each new number, we can either include it or exclude it
 * in every existing subset, so we double the result size with each number.
 *
 * Pitfall: save result.size() before the inner loop, otherwise newly added
 * subsets will be iterated over and cause duplicates.
 */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Keep track of possible subsets
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        // For each number, expand result by adding it to every existing subset
        for (int num : nums) {
            // Save size before loop so new additions don't affect iteration
            int size = result.size();
            // Go through the current results array
            for (int i = 0; i < size; i++) {
                // Grab a copy of the subset at index i
                List<Integer> subset = new ArrayList<>(result.get(i));
                // Add the curr num to this subset
                subset.add(num);
                // Add this subset to results
                result.add(subset);
            }
        }

        return result;
    }
}