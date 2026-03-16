// LeetCode 797. All Paths From Source to Target
package allpathsfromsourcetotarget;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // store all paths
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // maintain all paths during recursion
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* graph traverse template */
    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // add node s into path
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // reach the end
            res.add(new LinkedList<>(path));
        }

        // recursively traverse adjacent nodes
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // remove the node from the path
        path.removeLast();
    }
}
