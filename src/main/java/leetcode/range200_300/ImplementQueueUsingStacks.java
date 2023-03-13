package leetcode.range200_300;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    class MyQueue {
        private Stack<Integer> main;
        private Stack<Integer> secondary;

        private int head;

        public MyQueue() {
            main = new Stack<>();
            secondary = new Stack<>();
        }

        public void push(int x) {
            if(main.empty()) head = x;
            main.push(x);
        }

        public int pop() {
            while (main.size() != 1) {
                secondary.push(main.pop());
            }
            int result = main.pop();
            while (!secondary.empty()) {
                this.push(secondary.pop());
            }
            return result;
        }

        public int peek() {
            return this.head;
        }

        public boolean empty() {
            return main.empty();
        }
    }
}
