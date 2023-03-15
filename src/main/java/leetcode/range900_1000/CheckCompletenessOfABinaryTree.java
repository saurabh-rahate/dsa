package leetcode.range900_1000;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.peek() != null) {
            TreeNode node = q.poll();
            q.add(node.left);
            q.add(node.right);
        }

        while (!q.isEmpty() && q.peek() == null) q.poll();

        return q.isEmpty();
    }
}
