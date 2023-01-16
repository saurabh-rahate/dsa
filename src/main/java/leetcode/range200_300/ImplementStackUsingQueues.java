package leetcode.range200_300;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False
    }
    static class MyStack {
        private Queue<Integer> mainQueue;

        public MyStack() {
            this.mainQueue = new LinkedList<>();
        }

        public void push(int x) {
            this.mainQueue.add(x);
        }

        public int pop() {
            if (this.mainQueue.size() > 1) {
                int size = this.mainQueue.size();
                while (size-- > 1) this.mainQueue.add(this.mainQueue.poll());
            }
            return this.mainQueue.poll();
        }

        public int top() {
            if (this.mainQueue.size() > 1) {
                int size = this.mainQueue.size();
                while (size-- > 1) this.mainQueue.add(this.mainQueue.poll());
                int lastElement = this.mainQueue.poll();
                this.mainQueue.add(lastElement);
                return lastElement;
            } else {
                return this.mainQueue.peek();
            }
        }

        public boolean empty() {
            return this.mainQueue.isEmpty();
        }
    }

    class MyStack1 {
        private LinkedList<Integer> queue;

        public MyStack1() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            this.queue.add(x);
        }

        public int pop() {
            return this.queue.pollLast();
        }

        public int top() {
            return this.queue.getLast();
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
