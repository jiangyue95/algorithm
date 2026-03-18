// Union-Find class
package basicdatastructure;

public class UF {
    // count of the connected components
    private int count;
    // store the parent node of each node
    private int[] parent;

    // n is the count of nodes in the graph
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i--) {
            parent[i] = i;
        }
    }

    /* connect node p and node q */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        parent[rootQ] = rootP;
        count--;
    }

    /* check if node p and node q are connected */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // return the count of connected components in the graph
    public int count() {
        return count;
    }
}
