/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) {
                break;
            }

            ListNode groupNext = kthNode.next;
            
            ListNode prev = groupNext;
            ListNode current = groupPrev.next;
            
            while (current != groupNext) {
                ListNode tempNext = current.next;
                current.next = prev;
                prev = current;
                current = tempNext;
            }
            
            ListNode temp = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = temp;
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode startNode, int k) {
        ListNode current = startNode;
        for (int i = 0; i < k && current != null; i++) {
            current = current.next;
        }
        return current;
    }
}