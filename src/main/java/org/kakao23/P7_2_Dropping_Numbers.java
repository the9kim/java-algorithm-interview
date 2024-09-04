package org.kakao23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P7_2_Dropping_Numbers {

    static class TreeNode {
        int idx;
        int target;
        int cardCnt;
        boolean satisfiedCardCnt;
        List<TreeNode> children;

        public TreeNode(int idx, int target, int cardCnt, boolean satisfiedCardCnt, List<TreeNode> children) {
            this.idx = idx;
            this.target = target;
            this.cardCnt = cardCnt;
            this.satisfiedCardCnt = satisfiedCardCnt;
            this.children = children;
        }
    }

    public int[] solution(int[][] edges, int[] target) {

        TreeNode root = generateTree(edges, target);

        int placeHold = (int) Arrays.stream(target).filter(e -> e != 0).count();
        List<TreeNode> leafSequence = updateLeafNodeCardCnt(root, placeHold);

        if (leafSequence == null) {
            return new int[]{-1};
        }

        List<Integer> droppedCards = calculateDroppedCardValues(leafSequence);

        return droppedCards.stream().mapToInt(Integer::intValue).toArray();
    }

    private TreeNode generateTree(int[][] edges, int[] target) {
        Map<Integer, TreeNode> treeNodes = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            treeNodes.put(i, new TreeNode(i, target[i], 0, false, new ArrayList<>()));
        }

        for (int[] edge : edges) {
            int srcIdx = edge[0] - 1;
            int dstIdx = edge[1] - 1;
            TreeNode parent = treeNodes.get(srcIdx);
            TreeNode child = treeNodes.get(dstIdx);
            parent.children.add(child);
        }

        for (TreeNode node : treeNodes.values()) {
            node.children.sort(Comparator.comparingInt(n -> n.idx));
        }

        return treeNodes.get(0);
    }

    private List<TreeNode> updateLeafNodeCardCnt(TreeNode root, int placeHold) {
        List<TreeNode> leafSequence = new ArrayList<>();

        while (placeHold > 0) {

            TreeNode currNode = root;

            while (!currNode.children.isEmpty()) {
                TreeNode nextNode = currNode.children.remove(0);
                currNode.children.add(nextNode);

                currNode = nextNode;
            }

            currNode.cardCnt++;
            leafSequence.add(currNode);

            if (currNode.cardCnt > currNode.target) {
                return null;
            }
            if (!currNode.satisfiedCardCnt && currNode.cardCnt * 3 >= currNode.target) {
                placeHold--;
                currNode.satisfiedCardCnt = true;
            }
        }
        return leafSequence;
    }

    private List<Integer> calculateDroppedCardValues(List<TreeNode> leafSequence) {
        List<Integer> droppedCards = new ArrayList<>();

        for (TreeNode leaf : leafSequence) {
            leaf.cardCnt--;

            for(int n = 1; n <= 3; n++) {
                if (leaf.target - n <= leaf.cardCnt * 3) {
                    leaf.target -= n;
                    droppedCards.add(n);
                    break;
                }
            }
        }
        return droppedCards;
    }
}
