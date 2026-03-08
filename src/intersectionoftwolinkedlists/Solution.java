// LeetCode 160. Intersection of Two Linked Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
package intersectionoftwolinkedlists;

import basicdatastructure.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 points the head of listA
        ListNode p1 = headA;
        // p2 points the head of listB
        ListNode p2 = headB;

        while (p1 != p2) {
            // p1 moves one step, when it reaches the end of listA
            // turn to listB
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            // p2 moves one step, when it reaches the end of listB
            // turn to listA

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
