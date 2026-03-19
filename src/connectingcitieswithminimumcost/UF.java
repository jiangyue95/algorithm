// Union-Find class with size records weight of each edge
package connectingcitieswithminimumcost;

public class UF {
    // the count of connected components
    private int count;
    // store a tree
    private int[] parent;
    // store the weight of a tree
    private int[] size;

    // n is the count of the graph
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // connect node p and node q
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        // small tree connect to large tree
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        // merge two connected components
        count--;
    }

    // check if the node p and node q connect
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    // return the root node of node x
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // return the count of the connected components in the graph
    public int count() {
        return count;
    }
}
