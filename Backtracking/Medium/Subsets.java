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