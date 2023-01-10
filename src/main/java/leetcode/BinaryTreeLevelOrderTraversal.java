package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    private static List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        levelOrder(root, 0);
        return result;
    }

    private void levelOrder(TreeNode root, int level) {
        if (root == null) return;
        addInList(level, root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }

    private void addInList(int level, int element) {
        try {
            List<Integer> list = result.get(level);
            list.add(element);
        } catch (IndexOutOfBoundsException e) {
            List<Integer> list = new ArrayList<>();
            list.add(element);
            result.add(list);
        }
    }
}
