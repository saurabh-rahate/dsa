package leetcode;

public class MaximumDepthOfBinaryTree {
    private static int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        maxDepth(root, 1);
        return maxDepth;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(depth - 1, maxDepth);
            return;
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
}
