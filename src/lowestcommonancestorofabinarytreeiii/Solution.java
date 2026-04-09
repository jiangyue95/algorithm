// LeetCode 1650. Lowest Common Ancestor of a Binary Tree III
package lowestcommonancestorofabinarytreeiii;

import basicdatastructure.Node;

public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // using the linked list two pointers
        Node a = p;
        Node b = q;

        while (a != b) {
            // a moves one step, if it arrives at root, transfer to node q
            if (a == null) {
                a = q;
            } else {
                a = a.parent;
            }

            // b moves one step, if it arrives at root, transfer to node p
            if (b == null) {
                b = p;
            } else {
                b = b.parent;
            }
        }

        return a;
    }
}
