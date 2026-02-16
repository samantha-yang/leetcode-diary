public class Solution {
    public ListNode reverseList(ListNode head) {
        // Set references to keep track of the previous, current, and next nodes
        ListNode prev = null;
        ListNode curr = head;

        // While there is a current node
        while (curr != null) {
            // Store the next node before changing the curr node reference
            ListNode temp = curr.next;
            // Reverse the curr node's pointer
            curr.next = prev;
            // Move the prev and curr references one step forward
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}