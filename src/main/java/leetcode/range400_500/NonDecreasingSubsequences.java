package leetcode.range400_500;

import java.util.*;
import java.util.stream.Collectors;

public class NonDecreasingSubsequences {
    private static HashSet<List<Integer>> set;

    public List<List<Integer>> findSubsequences(int[] nums) {
        set = new HashSet<>();

        ArrayList<Helper> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            list.add(new Helper(nums[i]));
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    tempList.add(nums[j]);
                } else {
                    if (tempList.size() != 0) {
                        list.getLast().addListToList(tempList);
                        tempList = new ArrayList<>();
                    }
                }
            }
            if (tempList.size() != 0) {
                list.getLast().addListToList(tempList);
            }
        }
        System.out.println(list);

        list.stream().forEach(helper -> addHelper(helper));


        return set.stream().collect(Collectors.toList());
    }

    private void addHelper(Helper helper) {
        helper.list.stream().forEach(list -> addListNumbersToSet(helper.number, list));
    }

    private void addListNumbersToSet(int main, ArrayList<Integer> list) {
        while (list.size() > 0) {
            if (list.size() > 1) {
                List<Integer> a = new ArrayList<>();
                a.add(main);
                a.addAll(list);
                set.add(a);
            }
            set.add(List.of(main, list.pollFirst()));
        }
    }

    static class Helper {
        private int number;
        private List<ArrayList<Integer>> list;

        public Helper(int number) {
            this.number = number;
            this.list = new ArrayList<>();
        }

        public void addListToList(ArrayList<Integer> listOfContinuousNumber) {
            this.list.add(listOfContinuousNumber);
        }

        @Override
        public String toString() {
            return this.number + " - " + this.list.toString();
        }
    }
}
