package leetcode.range2300_2400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

// TODO: HARD - TLE
public class LongestCycleInAGraph {

    public static void main(String[] args) {
        LongestCycleInAGraph obj = new LongestCycleInAGraph();
        System.out.println(obj.longestCycle(new int[]{3, 3, 4, 2, 3}));
        System.out.println(obj.longestCycle(new int[]{2, -1, 3, 1}));
    }

    public int longestCycle(int[] edges) {
        int maxCycle = -1;

        Node[] nodeList = new Node[edges.length];
        IntStream.range(0, edges.length).forEach(n -> {
            if (nodeList[n] == null) {
                nodeList[n] = new Node(n);
            }
            int edgeTo = edges[n];
            if (edgeTo != -1) {
                if (nodeList[edgeTo] == null) {
                    nodeList[edgeTo] = new Node(edgeTo);
                }
                nodeList[n].nextNode = nodeList[edgeTo];
            }
        });

        for (Node node : nodeList) {
            if (node.covered) continue;
            LinkedList<Node> tempList = new LinkedList<>();
            while (node != null) {
                if (node.visited) {
                    break;
                } else {
                    tempList.add(node);
                    node.cover().visit();
                    node = node.nextNode;
                }
            }
            if (node != null) {
                while (tempList.peek() != node) {
                    tempList.poll().unVisit();
                }
                maxCycle = Math.max(maxCycle, tempList.size());
            }
            tempList.forEach(Node::unVisit);
        }
        return maxCycle;
    }

    static class Node {
        int val;
        boolean visited;
        boolean covered;
        Node nextNode;

        public Node(int val) {
            this.val = val;
            this.visited = false;
            this.covered = false;
        }

        public void addNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public void visit() {
            visited = true;
        }

        public Node cover() {
            covered = true;
            return this;
        }

        public void unVisit() {
            visited = false;
        }

        @Override
        public String toString() {
            StringBuilder toStr = new StringBuilder("[" + val + " -> ");
            if (nextNode != null) toStr.append(nextNode.val);
            return toStr + " ]";
        }
    }
}

