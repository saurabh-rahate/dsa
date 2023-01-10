package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    private static List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
