package leetcode.range200_300;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        findNodeAndAddPathToList(root, p, pList);

        List<TreeNode> qList = new ArrayList<>();
        findNodeAndAddPathToList(root, q, qList);

        pList.retainAll(qList);
        return pList.get(pList.size() - 1);
    }

    private static void findNodeAndAddPathToList(TreeNode root, TreeNode nodeToFind, List<TreeNode> list) {
        list.add(root);
        if (root.val == nodeToFind.val) return;
        if (nodeToFind.val < root.val)
            findNodeAndAddPathToList(root.left, nodeToFind, list);
        else
            findNodeAndAddPathToList(root.right, nodeToFind, list);
    }
}
