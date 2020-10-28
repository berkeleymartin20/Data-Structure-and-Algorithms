/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */

import java.util.Stack;

public class Valid_Parentheses {

    /**
     * Given input string of parentheses is valid if each bracket or parenthesis is paired with its complement
     * @param s string of parentheses and brackets
     * @return true if each bracket or parenthesis is paired, false otherwise
     */
    public boolean isValid(String s) {
        //stack to keep track of the more recent left bracket/parenthesis
        Stack<Character> list = new Stack<>();

        //for each character of the string, store the left bracket/parenthesis, and try to match if it's the right component
        //if the pair isn't found to the most recent one, method returns false.
        //If all of the parts are matched, return true at the end if stack is empty
        for (int x = 0; x< s.length(); x++) {
            char curr = s.charAt(x);
            if (curr == '(' || curr == '[' || curr == '{') {
                list.push(curr);
            } else if (curr == ')' || curr == ']' || curr == '}') {
                if(list.isEmpty()) {
                    return false;
                }

                char recent = list.pop();
                if (recent == '(' && curr == ')') {
                    continue;
                } else if (recent == '{' && curr == '}') {
                    continue;
                } else if (recent == '[' && curr == ']') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (list.isEmpty()){
            return true;
        } else{
            return false;
        }

    }
}
