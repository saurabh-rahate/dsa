package leetcode.range0_100;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(obj.combinationSum(new int[]{2, 3, 5}, 8));
    }

    HashSet<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new HashSet<>();
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(candidates).forEach(set::add);

        getSumNumbers(set, target, new ArrayList<>());
        return result.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    private void getSumNumbers(TreeSet<Integer> set, int toFindSum, List<Integer> listOfNumbers) {
        set.stream().filter(n -> n <= toFindSum).forEach(candidate -> {
            List<Integer> newList = new ArrayList<>(listOfNumbers);
            newList.add(candidate);
            if (candidate == toFindSum) {
                newList.sort(Integer::compareTo);
                result.add(newList);
            } else {
                getSumNumbers(set, toFindSum - candidate, newList);
            }
        });
    }
}
