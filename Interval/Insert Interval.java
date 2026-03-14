public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        // Go through list of intervals
        for (int[] interval : intervals) {
            // Current interval ends before newInterval starts — no overlap, safe to add as-is
            if (newInterval == null || interval[1] < newInterval[0]) {
                result.add(interval);
            // Current interval starts after newInterval ends — no overlap, so insert newInterval
            // first, then add the current interval. Nullify newInterval since it's been placed.
            } else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            // Intervals overlap — merge by expanding newInterval to cover both
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        // If newInterval was never inserted (e.g. it belongs at the end, or intervals was empty),
        // append it now
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }
}