package leetcode.range1400_1500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, true, false, true, true, false)));
        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, true, false, false, true, false)));
        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, false, false, false, false, false)));
        System.out.println(minTime(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, List.of(false, true, false, false)));
    }

    private static HashSet<Integer> set;

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        set = new HashSet<>();

        List<UTreeNode> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) list.add(new UTreeNode(i));

        for (int[] edge : edges) {
            UTreeNode parentNode = list.get(edge[0]);
            UTreeNode childNode = list.get(edge[1]);

            if (parentNode.val != 0 && parentNode.parent == null) {
                UTreeNode temp = childNode;
                childNode = parentNode;
                parentNode = temp;
            }
            childNode.addParent(parentNode);
        }

        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) trackTheParent(list.get(i));
        }
        return set.size() * 2;
    }

    private static void trackTheParent(UTreeNode node) {
        if (node.val != 0 && set.add(node.val))
            trackTheParent(node.parent);
    }

    static class UTreeNode {
        public UTreeNode parent;

        public int val;

        public UTreeNode(int val) {
            this.val = val;
        }

        public void addParent(UTreeNode node) {
            this.parent = node;
        }

        @Override
        public String toString() {
            String res = "" + val + "-";
            res += parent != null ? parent.val + "-" : "NULL";
            return res;
        }
    }
}
