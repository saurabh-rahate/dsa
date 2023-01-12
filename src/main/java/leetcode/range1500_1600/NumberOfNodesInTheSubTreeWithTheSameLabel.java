package leetcode.range1500_1600;

import java.util.Arrays;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithTheSameLabel obj = new NumberOfNodesInTheSubTreeWithTheSameLabel();

        long start = System.nanoTime();
        Arrays.stream(obj
                .countSubTrees1(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd")).asLongStream().forEach(System.out::println);
        long end = System.nanoTime();

        long execution = (end - start);
        System.out.println("Execution time of Recursive Method is");
        System.out.println(execution + " nanoseconds");

        System.out.println("Char added times: " + addToParentCount);

        Arrays.stream(obj
                .countSubTrees1(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, "bbbb")).asLongStream().forEach(System.out::println);

//        long rounds = 1000L;
//        List<Long> executionTimes = new ArrayList<>();
//        for (int i = 0; i < rounds; i++) {
//            start = System.nanoTime();
//            obj.countSubTrees1(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");
//            end = System.nanoTime();
//            execution = (end - start);
//            executionTimes.add(execution);
//        }

//        System.out.println("Exe Time: " + executionTimes.stream().mapToLong(Long::longValue).average().getAsDouble());

    }

    private static int[] result;
    private static long addToParentCount = 0L;

    public int[] countSubTrees1(int n, int[][] edges, String labels) {
        result = new int[n];
        UTreeNode[] map = new UTreeNode[n];

        for (int[] edge : edges) {
            int parentVal = edge[0];
            int childVal = edge[1];

            UTreeNode parentNode = map[parentVal];
            if (parentNode == null) {
                parentNode = new UTreeNode(parentVal, labels.charAt(parentVal));
                map[parentVal] = parentNode;
            }
            UTreeNode childNode = map[childVal];
            if (childNode == null) {
                childNode = new UTreeNode(childVal, labels.charAt(childVal));
                map[childVal] = childNode;
            }

            if (parentNode.val != 0 && parentNode.parent == null) {
                UTreeNode temp = childNode;
                childNode = parentNode;
                parentNode = temp;
            }
            childNode.addParent(parentNode);
        }

        Arrays.stream(map).filter(node -> node.val != 0)
                .forEach(node -> node.parent.addCharacterToParents(node.c));

        return result;
    }

    static class UTreeNode {
        public UTreeNode parent;
        public int val;
        public char c;
        public boolean hasChild;

        public UTreeNode(int val, char c) {
            this.val = val;
            this.c = c;
            this.hasChild = false;
            result[val]++;
        }

        public void addParent(UTreeNode node) {
            node.hasChild = true;
            this.parent = node;
        }

        private void addCharacterToParents(char c) {
            if (c == this.c) result[this.val]++;
            if (this.val != 0) this.parent.addCharacterToParents(c);
        }

//        private void addCharacterToParents2(char c) {
//
//        }

        @Override
        public String toString() {
            String res = "" + this.val + "-" + this.c + "-" + this.hasChild;
            res += this.parent != null ? this.parent.val + "-" : "NULL";
            return res;
        }
    }
}

//    public int[] countSubTrees2(int n, int[][] edges, String labels) {
//        char[] labelChars = labels.toCharArray();
//        List<UTreeNode> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            list.add(new UTreeNode(i, labelChars[i]));
//        }
//
//        for (int[] edge : edges) {
//            int parentVal = edge[0];
//            int childVal = edge[1];
//
//            UTreeNode parentNode = list.get(parentVal);
//            UTreeNode childNode = list.get(childVal);
//
//            if (parentNode.val != 0 && parentNode.parent == null) {
//                UTreeNode temp = childNode;
//                childNode = parentNode;
//                parentNode = temp;
//            }
//            childNode.addParent(parentNode);
//        }
//
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = list.get(i).countInSubtree;
//        }
//
//        return result;
//    }
//
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        char[] labelChars = labels.toCharArray();
//        Map<Integer, UTreeNode> map = new HashMap<>();
//
//        for (int[] edge : edges) {
//            int parentVal = edge[0];
//            int childVal = edge[1];
//
//            UTreeNode parentNode = map.get(parentVal);
//            if (parentNode == null) {
//                parentNode = new UTreeNode(parentVal, labelChars[parentVal]);
//                map.put(parentVal, parentNode);
//            }
//            UTreeNode childNode = map.get(childVal);
//            if (childNode == null) {
//                childNode = new UTreeNode(childVal, labelChars[childVal]);
//                map.put(childVal, childNode);
//            }
//
//            if (parentNode.val != 0 && parentNode.parent == null) {
//                UTreeNode temp = childNode;
//                childNode = parentNode;
//                parentNode = temp;
//            }
//            childNode.addParent(parentNode);
//        }
//
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = map.get(i).countInSubtree;
//        }
//
//        return result;
//    }