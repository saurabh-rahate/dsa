package leetcode;

import java.util.*;

public class AllPathsFromSourceToTarget {
    private static TreeMap<Integer, List<Integer>> mapOfNodes;
    private static List<List<Integer>> output;

    public static void main(String[] args) {
        allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        mapOfNodes = new TreeMap<>();
        output = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            int[] nodes = graph[i];
            for (int node : nodes) {
                mapOfNodes.computeIfAbsent(node, k -> new ArrayList<>());
                mapOfNodes.get(node).add(i);
            }
        }

        List<Integer> stack = new ArrayList<>();
        stack.add(mapOfNodes.lastEntry().getKey());
        backTrack(stack);

        System.out.println(output);
        return output;
    }

    private static void backTrack(List<Integer> stack) {
        List<Integer> connectedNodes = mapOfNodes.get(stack.get(stack.size() - 1));
        int i = 0;
        while (connectedNodes != null && i < connectedNodes.size()) {
            int connectedNode = connectedNodes.get(i++);
            List<Integer> newStack = new ArrayList<>(stack);
            newStack.add(connectedNode);
            if (connectedNode == 0) {
                List<Integer> result = new ArrayList<>(newStack);
                Collections.reverse(result);
                output.add(result);
            } else {
                backTrack(newStack);
            }
        }
    }
}
