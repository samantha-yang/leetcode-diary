import java.util.*;
class Solution {
    // Calculate the squared distance
    // Note: Do not need the sqrt as it is the same ordering
    // May need the sqrt if specifically asked for actual geometric distance
    public int squaredDis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        // Create a max heap ordered by squared distance (farthest point at the top)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            squaredDis(b) - squaredDis(a)
        );

        // Iterate through each point
        for (int[] p : points) {
            // Add current point to max heap
            maxHeap.offer(p);
            // If heap size exceeds k, then remove farthest point
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        // Create new resulting array
        int[][] res = new int[k][2];
        // Remove remaining k points from heap and store in resulting array
        for (int i = 0; i < k; i++)
            res[i] = maxHeap.poll();
        return res;
    }
}