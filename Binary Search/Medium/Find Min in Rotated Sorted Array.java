class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // Initialize the min to be the first elem as a guess
        int min = nums[0];

        while (l <= r) {
            // If the current subarray is already sorted,
            // the leftmost element is the min element
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            // Calculate midpoint: (start + end) / 2
            int mid = l + (r - l) / 2;
            // Check if the midpoint is the new min
            min = Math.min(min, nums[mid]);
            // If mid value >= left value, the left half is sorted
            // so the min must be in the right half
            // Move pointer past midpoint
            if (nums[mid] >= nums[l]) {
                // Move the left pointer
                l = mid + 1;
            // Else, mid is less than left, so we crossed rotation point
            // Min is in left half, so move right pointer
            } else {
                // Move the right pointer
                r = mid - 1;
            }
        }

        return min;
    }
}
