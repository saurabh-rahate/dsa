package leetcode.range100_200;

import leetcode.TreeNode;

public class MinimumDepthOfBinaryTree {

    private static int minLevel;

    public int minDepth(TreeNode root) {
        minLevel = Integer.MAX_VALUE;
        lookupForLeafNode(root, 0);
        return minLevel == Integer.MAX_VALUE ? 0 : minLevel;
    }

    private void lookupForLeafNode(TreeNode root, int level) {
        if (root == null) return;
        if (level < minLevel) {
            if (root.right == null && root.left == null) minLevel = level;
            else {
                lookupForLeafNode(root.left, level + 1);
                lookupForLeafNode(root.right, level + 1);
            }
        }
    }
}
