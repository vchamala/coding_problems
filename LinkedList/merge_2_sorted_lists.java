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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = null;
        
        if (list1 == null && list2 == null) { return null; }
        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }
        
        // initialize the new Head
        if (list1.val <= list2.val) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        
        ListNode newRoot = newHead;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newHead.next = list1;
                list1 = list1.next;
            } else {
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }
        
        // finish all list1
        while (list1 != null) {
            newHead.next = list1;
            list1 = list1.next;
            newHead = newHead.next;
        }
        
        // finish all list2
        while (list2 != null) {
            newHead.next = list2;
            list2 = list2.next;
            newHead = newHead.next;
        }
        
        return newRoot;
    }
}
