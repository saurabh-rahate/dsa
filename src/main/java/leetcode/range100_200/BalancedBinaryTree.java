package leetcode.range100_200;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalancedBinaryTree {

    private static List<Integer> list;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        list = new ArrayList<>();
        lookupForLeafNode(root, 1);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : list) {
            if (n > max) max = n;
            if (n < min) min = n;
        }
        int heightDiff = max - min;
        if (heightDiff == 0 || heightDiff == 1) return true;
        else return false;

    }

    private void lookupForLeafNode(TreeNode root, int level) {
        if(root == null) {
            addToList(level);
        } else {
            lookupForLeafNode(root.left, level +1);
            lookupForLeafNode(root.right, level +1);
        }
    }

    private void addToList(int level) {
        list.add(level);
    }
}
