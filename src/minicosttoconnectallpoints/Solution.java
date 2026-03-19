// LeetCode 1584. Mini Cost to Connect All Points
package minicosttoconnectallpoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // generate all edges and weight
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];
                // use index in the points as the representation
                edges.add(new int[] {i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        // order edges by the weight
        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        // execute Kruskal Algorithm
        int mst = 0;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // if this edge generate loop, this edge can not add to the mst
            if (uf.connected(u, v)) {
                continue;
            }
            // if this edge does not generate loop, add this edge into the mst
            mst += weight;
            uf.union(u, v);
        }
        return mst;
    }
}
