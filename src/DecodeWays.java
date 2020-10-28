/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: s = "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

public class DecodeWays {
    /**
     * Given a string of numbers, output how many ways the series of numbers could be interpreted into series of characters
     * using the 1 -> a ... 26 -> z mapping
     *
     * @param s string of numbers that represent characters
     * @return number of ways the string could be interpreted
     */
    public int numDecodings(String s) {

        //trivial case
        if (s.length() == 0) {
            return 0;
        }
        int[] solutions = new int[s.length() +1 ];

        //initialize the solutions array
        solutions[0] = 1;
        if (s.charAt(0) == '0') {
            solutions[1] = 0;
        } else {
            solutions[1] = 1;
        }

        //if the substring of curr and prev is between 10 and 26, add the cases where it could be interpreted as one letter for two numbers
        //if the substring of curr is between 1 and 9, add the cases where it could be interpreted as one letter for one number
        for(int x = 2; x < s.length() +1; x++) {
            String oneDigitS = s.substring(x-1,x);
            String twoDigitS = s.substring(x-2,x);

            int oneDigit = Integer.parseInt(oneDigitS);
            int twoDigit = Integer.parseInt(twoDigitS);

            if(1 <= oneDigit && oneDigit <= 9) {
                solutions[x] += solutions[x-1];
            }
            if (10<= twoDigit && twoDigit <= 26) {
                solutions[x] += solutions[x-2];
            }
        }
        //return the last number of the array that represents all possible ways to decode the string of numbers
        return solutions[s.length()];
    }
}
