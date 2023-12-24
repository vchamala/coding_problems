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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryForward = 0;
        ListNode newHead = new ListNode(111);
        ListNode newNode = newHead;
        while (l1 != null && l2 != null) {
            int newVal = 0;
            int val = l1.val + l2.val + carryForward;
            if (val >= 10) {
                newVal = val % 10;
                carryForward = val / 10;
            } else {
                newVal = val;
                carryForward = 0;
            }
            newNode.next = new ListNode(newVal);
            newNode = newNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            int newVal = 0;
            int val = l1.val + carryForward;
            if (val >= 10) {
                newVal = val % 10;
                carryForward = val / 10;
            } else {
                newVal = val;
                carryForward = 0;
            }
            newNode.next = new ListNode(newVal);
            l1 = l1.next;
            newNode = newNode.next;
        }
        
        while(l2 != null) {
            int newVal = 0;
            int val = l2.val + carryForward;
            if (val >= 10) {
                newVal = val % 10;
                carryForward = val / 10;
            } else {
                newVal = val;
                carryForward = 0;
            }
            newNode.next = new ListNode(newVal);
            l2 = l2.next;
            newNode = newNode.next;
        }
        
        // case where carry is still present - add this as new node.
        if (carryForward != 0) {
            newNode.next = new ListNode(carryForward);
        }
        
        // now reverse the LL and remove the 111 node.
        return newHead.next;
        
    }
}
