package leetcode;

import java.util.Collection;
import java.util.HashMap;

// TODO: Reduce time
public class MinimumRoundsToCompleteAllTasks {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(minimumRounds(new int[]{2, 3, 3}));
    }

    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Counter> map = new HashMap<>();

        for (int task : tasks) {
            Counter count = map.get(task);
            if (count == null) map.put(task, new Counter());
            else count.increment();
        }

        Collection<Counter> values = map.values();
        int sum = 0;
        for (Counter counter : values) {
            if (counter.count < 2) return -1;
            sum += canComplete(counter.count);
        }
        return sum;
    }

    private static int canComplete(int n) {
        return n % 3 == 0 ? n / 3 : n / 3 + 1;
    }

    static class Counter {
        public int count;

        Counter() {
            this.count = 1;
        }

        public void increment() {
            this.count++;
        }

        @Override
        public String toString() {
            return String.valueOf(this.count);
        }
    }
}
