package stack;

import java.util.Stack;

/**
 * @author Boli Tao
 */
public class Leetcode20 {
    public boolean isValid(String s) {
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                arrayStack.push(c);
            } else if (c == ']' || c == ')' || c == '}') {
                char temp = arrayStack.pop();
                if (c == ')' && temp != '(') {
                    return false;
                }
                if (c == ']' && temp != '[') {
                    return false;
                }
                if (c == '}' && temp != '{') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode20 test = new Leetcode20();
        System.out.println(test.isValid("a(((()"));
    }
}
