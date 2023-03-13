package leetcode.range0_100;


import leetcode.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return areSame(p, q);
    }

    private boolean areSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null)
            if (p.val == q.val) return areSame(p.left, q.left) && areSame(p.right, q.right);
            else return false;
        else return false;
    }
}
