package leetcode.range100_200;

import leetcode.TreeNode;

public class SumRootToLeafNumbers {
    private static int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        addNodes(root);
        return sum;
    }

    private void addNodes(TreeNode node) {
        if (isLeafNode(node)) sum += node.val;
        else if (isNodeWithTwoChildren(node)) {
            node.left.val += node.val * 10;
            node.right.val += node.val * 10;
            addNodes(node.left);
            addNodes(node.right);
        } else {
            getOnlyChild(node).val += node.val * 10;
            addNodes(getOnlyChild(node));
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private boolean isNodeWithTwoChildren(TreeNode node) {
        return node.left != null && node.right != null;
    }

    private TreeNode getOnlyChild(TreeNode node) {
        return node.left == null ? node.right : node.left;
    }
}
