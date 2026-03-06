/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort the meetings by their start time
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        // Go through interval list
        for (int i = 1; i < intervals.size(); i++) {
            // Get the first interval
            Interval i1 = intervals.get(i - 1);
            // Get the next interval
            Interval i2 = intervals.get(i);

            // If the end time of the first interval is after the start of the second interval
            // then the meetings interlap
            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }
}