// LeetCode 141. Linked List Cycle
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
package linkedlistcycle;

import basicdatastructure.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // init the fast and slow pointer point head
        ListNode slow = head;
        ListNode fast = head;
        // when fast pointer reaches end, stop
        while (fast != null && fast.next != null) {
            // slow pointer moves one step
            // fast pointer moves two steps
            slow = slow.next;
            fast = fast.next.next;
            // when fast and slow pointer meet, indicate there is a circle
            if (slow == fast) {
                return true;
            }
        }
        // there is no circle
        return false;
    }
}
