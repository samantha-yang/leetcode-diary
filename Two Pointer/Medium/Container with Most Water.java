class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            // Area is the minimum height * the distance between left and right
            int area = Math.min(heights[l], heights[r]) * (r - l);

            max = Math.max(area, max);

            // Move the pointer at the shorter height inward — 
            // if left is shorter, increment left; otherwise decrement right
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
