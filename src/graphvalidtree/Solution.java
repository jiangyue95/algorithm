// LeetCode 261. Graph Valid Tree
package graphvalidtree;

public class Solution {
    // check if the edges provided can construct a tree
    public boolean validTree(int n, int[][] edges) {
        // initializes n nodes from 0 to n - 1
        UF uf = new UF(n);

        // traverse all edges, connecte two nodes in edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // if two node already in one connected compoent, it will generate a loop
            if (uf.connected(u, v)) {
                return false;
            }

            // this edage dose not generate loop, connect two node
            uf.union(u, v);
        }
        // guarenteed only on tree, the count of connected components shouble be 1
        return uf.count() == 1;
    }
}
