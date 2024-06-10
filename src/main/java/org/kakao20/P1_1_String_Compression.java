package org.kakao20;

import java.util.HashMap;
import java.util.Map;

public class P1_1_String_Compression {

    /**
     * 1. Utilize iteration to calculate the length of the input string for each window size
     * 2. Utilize iteration to compress characters in the input string
     * 3. If the value of current window is different from the previous window, compress the previous window value
     * 4. If the value of current window equals to the previous window, increase the count of the value
     * 5. Process the elements that are not contained within the window
     * 6. Calculate the size of the compressed input
     */

    public int solution(String s) {
        int minLen = s.length();

        // 1
        for (int i = 1; i <= s.length(); i++) {
            Map<String, Integer> count = new HashMap<>();
            String preUnit = "";
            StringBuilder sb = new StringBuilder();
            int index = 0;

            // 2
            for (int j = 0; j + i <= s.length(); j = j + i) {
                index = j + i;
                String unit = s.substring(j, j + i);

                // 3
                if (!unit.equals(preUnit)) {
                    if (!preUnit.equals("")) {
                        if (count.get(preUnit) > 1) {
                            sb.append(count.get(preUnit));
                        }
                        sb.append(preUnit);
                    }
                    count.put(unit, 1);
                // 4
                } else if (unit.equals(preUnit)) {
                    count.put(unit, count.get(unit) + 1);
                }
                preUnit = unit;
            }

            // 5.
            if (count.get(preUnit) > 1) {
                sb.append(count.get(preUnit));
            }
            sb.append(preUnit);
            sb.append(s.substring(index));

            // 6.
            minLen = Math.min(minLen, sb.length());
        }
        return minLen;
    }

}
