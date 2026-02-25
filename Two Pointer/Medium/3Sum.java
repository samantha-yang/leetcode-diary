class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorted into ascending order using quicksort
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through the nums array
        for (int i = 0; i < nums.length; i++) {
            // If the num is greater than 0, break the loop
            if (nums[i] > 0) {
                break;
            }
            
            // If there is a duplicate, skip it
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Initialize two pointers, left and right
            int l = i + 1;
            int r = nums.length - 1;

            // While left is before right
            // Two pointer search for a pair that sums with nums[i] to 0
            while (l < r) {
                // Add up the nums
                int sum = nums[i] + nums[l] + nums[r];
                // If the sum is > 0, then move right pointer to the left to decrease the number
                if (sum > 0) {
                    r--;
                // Else, move left pointer to the right to get a bigger number
                } else if (sum < 0) {
                    l++;
                // There is a match
                } else {
                    // Add to result array
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // Move pointers
                    l++;
                    r--;
                    // Move left pointer to skip duplicates
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
