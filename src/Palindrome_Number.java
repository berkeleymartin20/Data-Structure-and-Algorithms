/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 */

/**
 * Example 1:
 * Input: x = 121
 * Output: true
 *
 *  Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class Palindrome_Number {
    /**
     * convert the given integer into a string and check if it's palindrome with two pointers, one in the front and one in the back
     * @param n given number to check if it's a palindrome
     * @return true/false depending on the number
     */
    public boolean isPalindrome(int n) {
        String number = Integer.toString(n);
        for (int x = 0; x < number.length(); x++ ) {
            if(number.charAt(x) != number.charAt(number.length()-1-x)) {
                return false;
            }
        }
        return true;
    }
}
