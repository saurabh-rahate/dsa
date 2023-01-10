package leetcode;


public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode root, int sum, int targetSum) {
        if(root == null) return false;
        if(root.right == null && root.left == null)
            return sum + root.val == targetSum;
        return pathSum(root.left, sum + root.val, targetSum) || pathSum(root.right, sum + root.val, targetSum);
    }
}
