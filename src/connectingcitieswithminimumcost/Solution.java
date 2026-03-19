// LeetCode 1135. Connecting Cities With Minimum Cost (Locked)
package connectingcitieswithminimumcost;

import java.util.Arrays;

public class Solution {
    public int minimmumCost(int n, int[][] connections) {
        // city number from 1 to n, hennce initialize the count as n + 1
        UF uf = new UF(n + 1);
        // order the edges by the weight
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        // store the sum of mst weight
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // if this edge generate loop, do not add to mst
            if (uf.connected(u, v)) {
                continue;
            }
            // if this edge does not generate loop, then add it to mst
            mst += weight;
            uf.union(u, v);
        }
        // guarentee all nodeed are connected
        return uf.count() == 2 ? mst : -1;
    }
}
