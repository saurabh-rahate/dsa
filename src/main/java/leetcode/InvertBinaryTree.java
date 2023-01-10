package leetcode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invert(root.left);
        invert(root.right);
    }
}
