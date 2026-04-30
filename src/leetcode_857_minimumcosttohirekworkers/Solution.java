// LeetCode 857. Minimum Cost to Hire K Workers
// Tags: Hot 100, Max Heap
package leetcode_857_minimumcosttohirekworkers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Create the workers array, ordered by the ratio of wage / quality
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));

        // Create a max heap stores the quality
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long totalQuality = 0;
        double ans = Double.MAX_VALUE;

        // Enumerate each ratio of the worker
        for (Worker w : workers) {
            // Add cureent worker's ratio
            pq.offer(w.quality);
            totalQuality += w.quality;

            // If the count exceed the k, remove the max
            if (pq.size() > k) {
                totalQuality -= pq.poll();
            }

            // When the count is k, calculate the cost
            if (pq.size() == k) {
                double cost = totalQuality * w.ratio;
                if (cost < ans) {
                    ans = cost;
                }
            }
        }

        return ans;
    }

    // Worker class
    static class Worker {
        int quality;
        double ratio;

        Worker(int q, int wage) {
            this.quality = q;
            this.ratio = (double) wage / q;
        }
    }
}
