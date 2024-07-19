package org.kakao19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P5_1_Path_Finding_Game {

    class TreeNode {
        int idx;
        int x;
        int y;
        TreeNode left;
        TreeNode right;

        public TreeNode(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    // 1. Sort the input nodes in descending order as heights and ascending order as width
    // 2. Create a binary Tree
    // 3. Find the pre-order and post-order routes

    public int[][] solution(int[][] nodeinfo) {

        // 1.
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new TreeNode(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if (o1.y == o2.y) {
                    return Integer.compare(o1.x, o2.x);
                } else {
                    return Integer.compare(o2.y, o1.y);
                }
            }
        });

        // 2.
        TreeNode root = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            TreeNode temp = root;
            TreeNode node = nodes.get(i);

            while (true) {
                if (node.x < temp.x) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }

        // 3.
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        preorder(root, preorder);
        postorder(root, postorder);

        return new int[][]{
                preorder.stream().mapToInt(Integer::intValue).toArray(),
                postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    public void preorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.idx);
        preorder(root.left, path);
        preorder(root.right, path);
    }

    public void postorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        postorder(root.left, path);
        postorder(root.right, path);
        path.add(root.idx);
    }

}
