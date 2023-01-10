package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    private static List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }

    private void preorder(TreeNode root) {
        if(root == null) return;
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
