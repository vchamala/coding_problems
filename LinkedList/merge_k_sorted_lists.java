// Used Priority Queue


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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue queue = new PriorityQueue();
        
        for (int i=0; i<lists.length; i++) {
            // insert all K LLs into priority based on value size..
            insertLinkedListIntoPriorityQueue(queue, lists[i]);
        }
        
        // No, from the queue items in the same order present, create the new LL.
        ListNode node = (ListNode) queue.poll();
        ListNode newHead = node;
        
        while(!queue.isEmpty) {
            node.next = queue.poll();
            node = node.next;
        }
        return newHead;
    }
    
    private PriorityQueue insertLinkedListIntoPriorityQueue(PriorityQueue queue, ListNode node) {
        if (node == null) {
            return queue;
        }
        while (node != null) {
            // inserting based on val priority..
            queue.add(node);
            node = node.next;
        }
        return queue;
    }
}
