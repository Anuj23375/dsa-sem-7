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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev=null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        
      if(head==null || head.next==null) return true;

      ListNode slow = head, fast = head,temp = head;
      while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
      }
       ListNode half= reverseList(slow);
    while(half!=null){
        if(temp.val != half.val) return false;
        half = half.next;
        temp = temp.next;
    }
    return true;

    }
}