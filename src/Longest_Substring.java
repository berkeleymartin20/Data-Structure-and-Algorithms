/*Given a string s, find the length of the longest substring without repeating characters.

Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

Example 2
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

import java.util.HashMap;

public class Longest_Substring {
    /**
     * Given a String s, return the longest substring without repeating characters
     * @param s entire string with unique substrings length of 1 or more
     * @return return the longest length of a substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {

        //keeps track of the characters in the current substring and the index of the first character of the substring
        HashMap<Character,Integer> map = new HashMap<>();
        int maxStreak = 0;
        int currStreak = 0;

        //loops through all of the string s and checks if the next character is contained in the substring
        for (int x = 0; x < s.length(); x++) {

            //if the map contains the next character, set the pointer of the loop to where the found character is, then reset the hashmap and current streak
            if (map.containsKey(s.charAt(x))) {
                x = map.get(s.charAt(x));
                map.clear();
                currStreak = 0;

             //if new character is found, add the character and its index to the hashmap
            } else {
                map.put(s.charAt(x),x);
                currStreak++;
            }
            //if the current streak is bigger than the max streak, replace the max streak with the current streak
            if(currStreak > maxStreak) {
                maxStreak = currStreak;
            }
        }
        return maxStreak;
    }
}
