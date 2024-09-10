package org.kakao19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P5_3_Path_Finding_Game {
    static class Node {
        int n;
        int y;
        int x;
        Node left;
        Node right;

        public Node(int n, int y, int x) {
            this.n = n;
            this.y = y;
            this.x = x;
        }
    }

    public int[][] solution(int[][] nodeinfo) {

        List<List<Node>> nodesSortedInLevel = preprocessNodes(nodeinfo);

        Node root = nodesSortedInLevel.get(0).get(0);
        root = buildTree(root, nodesSortedInLevel, 1, -1, 100001);

        List<Integer> preorder = preorderTraversal(root, new ArrayList<>());
        List<Integer> postorder = postorderTraversal(root, new ArrayList<>());

        return new int[][]{
                preorder.stream().mapToInt(Integer::intValue).toArray(),
                postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private List<List<Node>> preprocessNodes(int[][] nodeInfo) {
        Map<Integer, List<Node>> nodeMap = new HashMap<>();

        for (int i = 0; i < nodeInfo.length; i++) {
            int y = nodeInfo[i][1];
            int x = nodeInfo[i][0];

            nodeMap.putIfAbsent(y, new ArrayList<>());
            nodeMap.get(y).add(new Node(i + 1, y, x));
        }

        List<List<Node>> nodesSortedInLevel
                = nodeMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<Node>>comparingByKey(Comparator.reverseOrder()))
                .map(e -> {
                    List<Node> nodes = e.getValue();
                    nodes.sort(Comparator.comparingInt(n -> n.x));
                    return nodes;
                })
                .collect(Collectors.toList());

        return nodesSortedInLevel;
    }

    private Node buildTree(Node node, List<List<Node>> nodes, int idx, int minX, int maxX) {
        if (idx >= nodes.size()) {
            return node;
        }

        List<Node> childCandidates = nodes.get(idx);

        for (Node child : childCandidates) {
            if (child.x > minX && child.x < node.x) {
                node.left = buildTree(child, nodes, idx + 1, minX, node.x);
            } else if (child.x > node.x && child.x < maxX) {
                node.right = buildTree(child, nodes, idx + 1, node.x, maxX);
            }
        }
        return node;
    }

    private List<Integer> preorderTraversal(Node node, List<Integer> path) {
        if (node == null) {
            return null;
        }
        path.add(node.n);

        preorderTraversal(node.left, path);
        preorderTraversal(node.right, path);

        return path;
    }

    private List<Integer> postorderTraversal(Node node, List<Integer> path) {
        if (node == null) {
            return null;
        }
        postorderTraversal(node.left, path);
        postorderTraversal(node.right, path);

        path.add(node.n);

        return path;
    }
}
