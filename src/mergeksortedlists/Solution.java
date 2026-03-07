// LeetCode 23. Merge k Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package mergeksortedlists;

import basicdatastructure.ListNode;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // base case
        if (lists.length == 0) {
            return null;
        }

        // virtual head node
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // priority queue (min-heap)
        // because ListNode is a custom data structure
        // when creating priority queue needs to define the comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, (a, b)->(a.val - b.val)
        );
        // add k lists' head node into min-heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // get the smallest node, link it to result list
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // pointer p keep moving
            p = p.next;
        }
        return dummy.next;
    }
}
