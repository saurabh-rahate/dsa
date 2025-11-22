package leetcode.range100_200;

import leetcode.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        else if (nums.length == 1) return new TreeNode(nums[0]);
        else if (nums.length == 2) {
            TreeNode node = new TreeNode(nums[0]);
            node.right = new TreeNode(nums[1]);
            return node;
        } else {
            int mid = nums.length % 2 == 0 ? 1 : 1;
            TreeNode root = new TreeNode(nums[mid]);
            fillLeft(nums, root, mid - 1);
            fillRight(nums, root, mid + 1);

            return root;
        }
    }

    private void fillLeft(int[] nums, TreeNode root, int leftIndex) {
        if (leftIndex >= 0) {
            root.left = new TreeNode(nums[leftIndex]);
            fillLeft(nums, root.left, leftIndex - 1);
        } else return;
    }

    private void fillRight(int[] nums, TreeNode root, int rightIndex) {
        if (rightIndex < nums.length) {
            root.right = new TreeNode(nums[rightIndex]);
            fillRight(nums, root.right, rightIndex + 1);
        } else return;
    }
}
