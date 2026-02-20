public class Solution {
    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        // Create a starting point for the merged list
        ListNode dummy = new ListNode(0);
        // Used to build the merged list
        ListNode current = dummy;

        // Traverse both lists and merge them
        while (list1 != null && list2 != null) {
            // If the curr value of list1 is smaller, add it and move to next node in list1
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            // Else, add the curr value of list2 and move to next node in list2
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // Move the next node of the
            current = current.next;
        }

        // Append any remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list, which is the next node of dummy
        return dummy.next;
    }
}