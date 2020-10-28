/**You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

/**Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/

public class Add_Two_Numbers {
    /**
     * Given two numbers in ListNode format (value and next) in reverse order, sum the two numbers and return the result in
     * ListNode format, also in reverse order
     * @param x first number in ListNode, reverse format. e.g.) 1234 -> 4,3,2,1
     * @param y second number in ListNode, reverse format e.g.) 1234 -> 4,3,2,1
     * @return sum of x and y
     */
    public ListNode addTwoNumbers(ListNode x, ListNode y) {
        //Represent the sum as a ListNode Object
        ListNode answer = new ListNode();
        //Pointer to keep track of the current node in the answer variable
        ListNode pointer = answer;

        //int carry represents the carries to sums over 10
        int carry = 0;
        //sum of next digits of x and y
        int sum = 0;

        //next digit in x
        int xnum;
        //next digit in y
        int ynum;

        while (x != null || y != null) {
            //get the next digits from x and y and add them together. If next digit of one of the numbers is null (doesn't exist),
            //then set the value of that digit to 0
            if(x == null) { xnum = 0;
            } else { xnum = x.val;
            }
            if (y == null) { ynum = 0;
            } else {
                ynum = y.val;
            }

            sum = xnum + ynum;
            //mod the sum, in case the sum if above 10. If the sum is bigger than 10, the carrying number is set to the variable "carry"
            int tempOnes = sum %10;
            if(tempOnes + carry < 10) {
                pointer.next = new ListNode(tempOnes + carry);
                carry = sum/10;
            } else {
                pointer.next = new ListNode((tempOnes + carry)%10);
                carry = sum/10 + 1;
            }

            //move the pointers to next digit
            if ( x != null) x = x.next;
            if ( y != null) y = y.next;
            pointer = pointer.next;
            //When both ListNodes have exhausted, add the carry to the end if there is one
            if (x == null && y == null && carry != 0)  pointer.next = new ListNode(carry);

        }
        //Return the answer ListNode.next excluding the headnode
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


