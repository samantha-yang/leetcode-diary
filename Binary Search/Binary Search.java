class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // While the left pointer is less than or equal to right
        while (l <= r) {
            // Set mid point, start + half of remaining
            int mid = l + ((r - l) / 2);
            // If the mid point is larger than the target
            if (nums[mid] > target) {
                // Move right pointer to mid point - 1
                r = mid - 1;
            // If the mid point is less than the target
            } else if (nums[mid] < target) {
                // Move left pointer to mid point + 1
                l = mid + 1;
            // Else, we have found the target index
            } else {
                return mid;
            }
        }

        return - 1;
    }
}
