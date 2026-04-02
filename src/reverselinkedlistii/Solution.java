// LeetCode 92.Reverse Linked List II
// using the thought of recurse

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
package reverselinkedlistii;

import basicdatastructure.ListNode;

public class Solution {
    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            return reverseN(head, right);
        }

        // move the reversed starting point
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;

    }

    // reverse the first n node
    public ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            successor = head.next;
            return head;
        }

        // make head.next as starting, reverse the n - 1 node
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }
}
