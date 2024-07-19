package org.kakao19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P5_2_Path_Finding_Game {

    static class TreeNode {
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

    int preorderIdx = 0;
    int postorderIdx = 0;

    public int[][] solution(int[][] nodeinfo) {
        // 1. Sort the input nodes in descending order as height values
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new TreeNode(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        nodes.sort((o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            } else {
                return Integer.compare(o2.y, o1.y);
            }
        });


        // 2. Create a binary tree
        TreeNode root = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            createTree(root, nodes.get(i));
        }


        // 3. Find preorder and inorder routes
        int[] preorder = new int[nodes.size()];
        int[] postorder = new int[nodes.size()];
        preorder(root, preorder);
        postorder(root, postorder);

        int[][] answer = {preorder, postorder};

        return answer;
    }

    public void createTree(TreeNode parent, TreeNode child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
                return;
            } else {
                createTree(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
                return;
            } else {
                createTree(parent.right, child);
            }
        }
    }

    public void preorder(TreeNode root, int[] preorder) {
        if (root == null) {
            return;
        }

        preorder[preorderIdx++] = root.idx;

        preorder(root.left, preorder);
        preorder(root.right, preorder);
    }

    public void postorder(TreeNode root, int[] postorder) {
        if (root == null) {
            return;
        }

        postorder(root.left, postorder);
        postorder(root.right, postorder);

        postorder[postorderIdx++] = root.idx;
    }
}
