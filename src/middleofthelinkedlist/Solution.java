// LeetCode 876. Middle of the Linked List
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
package middleofthelinkedlist;

import basicdatastructure.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        // fast and slow pointer point to head
        ListNode slow = head;
        ListNode fast = head;

        // when fast pointer reach end node stop
        while (fast != null && fast.next != null) {
            // slow move one step
            // fast move two steps
            slow = slow.next;
            fast = fast.next.next;
        }
        // the slow pointer points middle node
        return slow;
    }
}
