package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIVInputIsABST {

    private static Set<Integer> list;

    public boolean findTarget(TreeNode root, int k) {
        list = new HashSet<>();
        inorder(root);
        for (int n : list) {
            int numberToFind = k - n;
            if (n != numberToFind && list.contains(numberToFind)) return true;
        }
        return false;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

//    private static boolean findInTree(TreeNode node, int n) {
//        if (node == null) return false;
//        if (node.val == n) return true;
//        if (n < node.val) return findInTree(node.left, n);
//        else return findInTree(node.right, n);
//    }

}
