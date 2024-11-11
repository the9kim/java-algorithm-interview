package org.kakao23;

public class P4_2_Representable_Binary_Tree {

    public int[] solution(long[] numbers) {
        int[] results = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            String bin = Long.toBinaryString(num);

            int nodeNums = findNodeNums(bin);
            String binaryTree = addPadding(bin, nodeNums);

            if (canRepresentable(binaryTree, 0, binaryTree.length() - 1, true)) {
                results[i] = 1;
            } else {
                results[i] = 0;
            }
        }

        return results;
    }

    private int findNodeNums(String bin) {

        int nodeNums = 0;
        int level = 0;

        while (bin.length() > nodeNums) {
            nodeNums += Math.pow(2, level);
            level++;
        }

        return nodeNums;
    }

    private String addPadding(String bin, int nodeNums) {
        String padding = "0".repeat(nodeNums - bin.length());

        return padding + bin;
    }

    private boolean canRepresentable(String binaryTree, int left, int right, boolean hasParent) {

        if (left > right) {
            return true;
        }

        int mid = left + (right - left) / 2;

        if (!hasParent && binaryTree.charAt(mid) == '1') {
            return false;
        }

        hasParent = binaryTree.charAt(mid) == '1' ? true : false;

        if (!canRepresentable(binaryTree, left, mid - 1, hasParent)) {
            return false;
        }
        if (!canRepresentable(binaryTree, mid + 1, right, hasParent)) {
            return false;
        }

        return true;
    }

}
