package leetcode.range0_100;

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(")()())"));
        System.out.println(obj.longestValidParentheses("(()"));
        System.out.println(obj.longestValidParentheses("()(()"));
    }

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public int longestValidParentheses1(String s) {
        if (s.length() == 0) return 0;
        int maxCount = 0;
        int currentCount = 0;

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == OPEN) {
                stack.add(c);
                currentCount++;
            }

            if (c == CLOSE) {
                if (stack.isEmpty()) {
                    // ignore
                } else {
                    stack.pollLast();
                    currentCount++;
                    maxCount = Math.max(currentCount, maxCount);
                }
            }
        }

        return maxCount;
    }


    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int maxCount = 0;
        int currentCount = 0;

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == OPEN) {
                stack.push(c);
                currentCount++;
            } else {
                if (stack.size() > 0) {
                    char lastChar = stack.getLast();
                    if (lastChar == CLOSE) {
                        maxCount = Math.max(currentCount - 1, maxCount);
                        currentCount = 0;
                        stack = new LinkedList<>();
                    } else {
                        stack.pollLast();
                        currentCount++;
                        maxCount = Math.max(maxCount, currentCount);
                    }
                }

            }
        }
        if (!stack.isEmpty()) maxCount -= stack.size();

        return maxCount;
    }
}
