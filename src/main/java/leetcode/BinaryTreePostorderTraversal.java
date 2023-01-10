package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    private static List<Integer> result;

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        postorder(root);
        return result;
    }

    private void postorder(TreeNode root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        result.add(root.val);
    }
}
