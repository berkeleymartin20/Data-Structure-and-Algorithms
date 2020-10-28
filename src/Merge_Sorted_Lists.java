/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */

public class Merge_Sorted_Lists {

    /**
     * Merge two sorted lists based on the next node's value. smaller number has precedence
     * @param l1 first list's head node
     * @param l2 second list's head node
     * @return return the head of the merged list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //head node of the answer list
        ListNode answer = new ListNode();
        //pointer node to track the current position of the answer list
        ListNode pointer = answer;
        //until both lists are empty, compare the next nodes of each lists and insert the smaller of the two to the next position of the answer list
        //Update the head node if a node of a list has been moved to the answer list. Update the pointer node as well
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ListNode temp = new ListNode(l2.val);
                l2 = l2.next;
                pointer.next = temp;
                pointer = pointer.next;
            } else if (l2 == null) {
                ListNode temp = new ListNode(l1.val);
                pointer.next =temp;
                l1 = l1.next;
                pointer = pointer.next;
            } else if (l1.val < l2.val) {
                ListNode temp = new ListNode(l1.val);
                pointer.next = temp;
                l1 = l1.next;
                pointer = pointer.next;
            } else {
                ListNode temp = new ListNode(l2.val);
                pointer.next = temp;
                l2 = l2.next;
                pointer = pointer.next;
            }
        }
        return answer.next;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
