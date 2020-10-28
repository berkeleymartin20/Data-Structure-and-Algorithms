/**
 * Share
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */

import java.util.Arrays;

public class Longest_Common_Prefix {
    /**
     * Given a set of strings in an array, return the longest prefix among all of the strings in the array
     * @param strs array of strings
     * @return longest prefix among all strings in the array
     */
    public String longestCommonPrefix(String[] strs) {

        //trivial cases, where the array is empty or contains only one string
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        int streak = 0;
        boolean val = true;

        //nested for loop to compare the shortest string of the array to the rest, and break the loops once the streak is broken
        for (int x = 0; x < strs[0].length(); x++) {
            char letter = strs[0].charAt(x);
            for (int y = 1; y < strs.length; y++) {
                if (strs[y].charAt(x) != letter) {
                    val = false;
                }
            }

            if (val == true) {
                streak++;

            } else {
                break;
            }
        }
        return strs[0].substring(0,streak);
    }
}
