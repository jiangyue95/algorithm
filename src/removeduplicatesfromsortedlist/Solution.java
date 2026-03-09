// LeetCode 83. Remove Duplicates from Sorted List
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
package removeduplicatesfromsortedlist;

import basicdatastructure.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast]
                slow.next = fast;
                // slow++
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }

        // disconnect the duplicate node
        slow.next = null;
        return head;
    }
}
