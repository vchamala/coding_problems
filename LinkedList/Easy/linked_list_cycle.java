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
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null) { return false; }
        ListNode node = head;
        List<ListNode> visitedNodes = new ArrayList<>();
        while(node.next!=null) {
            visitedNodes.add(node);
            node = node.next;
            if (visitedNodes.contains(node)) {
                return true;
            }
        }
        return false;
    }
}
