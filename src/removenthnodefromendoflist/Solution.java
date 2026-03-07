// LeetCode 19. Remove Nth Node From End of List
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
package removenthnodefromendoflist;

import basicdatastructure.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // virtual node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // in order to nth node from end
        // should find the n + 1 th node firstly
        ListNode x = findFromEnd(dummy, n + 1);
        // delete nth node from end
        x.next = x.next.next;
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 move k steps first
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 point the n - k + 1 node, the nth node from end
        return p2;
    }
}
