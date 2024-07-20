package org.kakao19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P3_3_Candidate_Key {
    /**
     * The method using Bit operation
     *
     * 1. Calculate subsets of columns which meets uniqueness principle
     * 2. Sort the subsets in ascending order as the number of 1-bit
     * 3. Find subsets that meets minimality principle
     */

    int rowSize;
    int colSize;

    public int solution(String[][] relation) {
        int answer = 0;
        rowSize = relation.length;
        colSize = relation[0].length;
        List<Integer> candidates = new LinkedList<>();

        for (int i = 1; i < 1 << colSize; i++) {
            if (check(relation, i)) {
                candidates.add(i);
            }
        }

        candidates.sort(new Comparator<Integer>() {
            public int countBits(int n) {
                int ret = 0;
                while (n != 0) {
                    if ((n & 1) != 0) {
                        ret++;
                    }
                    n >>= 1;
                }
                return ret;
            }

            @Override
            public int compare(Integer o1, Integer o2) {
                int x = countBits(o1);
                int y = countBits(o2);
                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        while (!candidates.isEmpty()) {
            int n = candidates.remove(0);
            answer++;

            for (Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
                int c = it.next();
                if ((n & c) == n) {
                    it.remove();
                }
            }
        }
        return answer;
    }

    public boolean check(String[][] relation, int subset) {
        for (int a = 0; a < rowSize - 1; a++) {
            for (int b = a + 1; b < rowSize; b++) {
                boolean isSame = true;
                for (int k = 0; k < colSize; k++) {
                    if ((subset & 1 << k) == 0) {
                        continue;
                    }
                    if (!relation[a][k].equals(relation[b][k])) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    return false;
                }
            }
        }
        return true;
    }
}
