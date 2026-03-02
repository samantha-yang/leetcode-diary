public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map the each number to its frequency
        Map<Integer, Integer> count = new HashMap<>();
        // Go through array and build the pairs in the map
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Convert the map into a frequency list
        // [frequency, number]
        List<int[]> arr = new ArrayList<>();
        for (int key : count.keySet()) {
            arr.add(new int[] {count.get(key), key});
        }

        // Sort the list by frequency in descending order
        arr.sort((a, b) -> b[0] - a[0]);

        // Create resulting array
        int[] res = new int[k];
        // Grab the first k elements
        for (int i = 0; i < k; i++) {
            // Get [1] since that is the actual number
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}