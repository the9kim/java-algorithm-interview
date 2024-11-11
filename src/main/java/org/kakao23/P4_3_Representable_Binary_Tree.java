package org.kakao23;

import java.util.ArrayList;
import java.util.List;

public class P4_3_Representable_Binary_Tree {


    public int[] solution(long[] numbers) {
        List<Integer> results = new ArrayList<>();

        for (long n : numbers) {
            long treeSize = determineTreeSize(n);
            String bin = addPadding(n, treeSize);
            if (canRepresentable(bin, 0, bin.length() - 1, true)) {
                results.add(1);
            } else {
                results.add(0);
            }

        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private long determineTreeSize(long n) {

        for (int i = 0; i <= 32; i++) {
            long nodes = (long) (Math.pow(2, i)) - 1;

            if (nodes >= Long.toBinaryString(n).length()) {
                return nodes;
            }
        }
        return 0;
    }

    private String addPadding(long n, long treeSize) {
        String bin = Long.toBinaryString(n);
        long paddingSize = treeSize - bin.length();
        String padding = "0".repeat((int) paddingSize);

        return padding + bin;
    }

    private boolean canRepresentable(String bin, int left, int right, boolean hasParent) {
        if (left > right) {
            return true;
        }

        int mid = left + (right - left) / 2;

        if (hasParent == false && bin.charAt(mid) == '1') {
            return false;
        }

        if (bin.charAt(mid) == '1') {
            if (!canRepresentable(bin, left, mid - 1, true)) {
                return false;
            }
            if (!canRepresentable(bin, mid + 1, right, true)) {
                return false;
            }
        } else {
            if (!canRepresentable(bin, left, mid - 1, false)) {
                return false;
            }
            if (!canRepresentable(bin, mid + 1, right, false)) {
                return false;
            }
        }
        return true;
    }

}
