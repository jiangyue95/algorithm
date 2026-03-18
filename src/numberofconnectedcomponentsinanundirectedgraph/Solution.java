// Leetcode 323. Number of Connected Components in an Undirected Graph
package numberofconnectedcomponentsinanundirectedgraph;

import basicdatastructure.UF;

public class Solution {
    public int countConnectedComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        // connect each node
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        // return the count of connected components
        return uf.count();
    }
}
