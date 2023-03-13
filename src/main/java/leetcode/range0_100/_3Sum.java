package leetcode.range0_100;

import java.util.*;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Counter> map = new HashMap<>();
        for (int num : nums) {
            Counter c = map.get(num);
            if (c == null) map.put(num, new Counter());
            else c.increment();
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int toFind = -(nums[i] + nums[j]);

                if (map.containsKey(toFind)) {

                    Counter aCount = map.get(nums[i]);
                    Counter bCount = map.get(nums[j]);
                    Counter cCount = map.get(toFind);

                    aCount.decrement();
                    bCount.decrement();
                    cCount.decrement();

                    if (aCount.count >= 0 && bCount.count >= 0 && cCount.count >= 0)
                        addToResult(result, nums[i], nums[j], toFind);

                    aCount.increment();
                    bCount.increment();
                    cCount.increment();
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static void addToResult(Set<List<Integer>> result, int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;
        result.add(List.of(min, mid, max));
    }

    static class Counter {
        public int count;

        Counter() {
            this.count = 1;
        }

        public void increment() {
            this.count++;
        }

        public void decrement() {
            this.count--;
        }

        @Override
        public String toString() {
            return String.valueOf(this.count);
        }
    }
}
