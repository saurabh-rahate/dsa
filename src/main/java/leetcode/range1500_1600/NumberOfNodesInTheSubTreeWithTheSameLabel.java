package leetcode.range1500_1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithTheSameLabel obj = new NumberOfNodesInTheSubTreeWithTheSameLabel();

        Arrays.stream(obj
                .countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd")).asLongStream().forEach(System.out::println);
//
//        Arrays.stream(obj
//                .countSubTrees(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, "bbbb")).asLongStream().forEach(System.out::println);

//        Arrays.stream(obj
//                .countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed")).asLongStream().forEach(System.out::println);
    }

    private static String labels;
    private static List<Integer>[] list;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        NumberOfNodesInTheSubTreeWithTheSameLabel.labels = labels;
        list = new List[n];
        int[] covered = new int[n];

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if (x == 0 || y == 0) {
                if (y == 0) {
                    int temp = y;
                    y = x;
                    x = temp;
                }
            } else {
                if (covered[x] == 0) {
                    int temp = y;
                    y = x;
                    x = temp;
                }
            }

            List<Integer> childrens = list[x];
            if (childrens == null) {
                childrens = new ArrayList<>();
                list[x] = childrens;
            }
            childrens.add(y);
            covered[x]++;
        }


//        Arrays.stream(list).forEach(System.out::println);
        return getLabelsInSubTree(0);
    }

    private static int[] getLabelsInSubTree(int root) {
        List<Integer> children = list[root];
        if (children == null) {
            int[] result = new int[26];
            result[getIndexInArray(getCharAt(root))]++;
            return result;
        } else {
            int[] result = new int[26];
            result[getIndexInArray(getCharAt(root))]++;
            for (int child : children) {
                int[] tempLabelsCount = getLabelsInSubTree(child);
                for (int i = 0; i < 26; i++) {
                    result[i] += tempLabelsCount[i];
                }
            }
            return result;
        }
    }

    private static char getCharAt(int n) {
        return labels.charAt(n);
    }

    private static int getIndexInArray(char c) {
        return c - 'a';
    }

}
