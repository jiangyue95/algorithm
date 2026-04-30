// LeetCode 857. Minimum Cost to Hire K Workers
// Tags: Hot 100, Max Heap
package leetcode_857_minimumcosttohirekworkers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // 1.创建工人数组，按比值排序
        // Create the workers array, ordered by the ratio of wage / quality
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        // 写了一个自定义的 比较算法
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));

        // 2. 大根堆（Max heap）存 quality （用负数模拟），long 防溢出
        // Create a max heap stores the quality
        // 自定义比较器
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long totalQuality = 0;
        double ans = Double.MAX_VALUE;

        // 3. 枚举每个工人作为比值上限
        // Enumerate each ratio of the worker
        for (Worker w : workers) {
            // 加当前工人的 quality
            // Add cureent worker's ratio
            pq.offer(w.quality);
            totalQuality += w.quality;

            // 堆超 k 个，移除质量最大的（保持质量最小）
            // If the count exceed the k, remove the max
            if (pq.size() > k) {
                totalQuality -= pq.poll();
            }

            // 堆正好 k 个时，计算成本
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

    // 工人类
    // Worker class
    static class Worker {
        int quality;
        double ratio; // wage / quality

        Worker(int q, int wage) {
            this.quality = q;
            this.ratio = (double) wage / q;
        }
    }
}
