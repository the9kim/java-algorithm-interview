package org.kakao20;

public class P1_2_String_Compression {

    public int solution(String s) {
        int optimalCompressionSize = Integer.MAX_VALUE;

        for (int windowSize = 1; windowSize <= s.length() / 2 + 1; windowSize++) {

            StringBuilder compressed = new StringBuilder();

            int duplicateCount = 1;
            String prevSub = s.substring(0, windowSize);

            int start;

            for (start = windowSize; start + windowSize <= s.length(); start += windowSize) {

                String currSub = s.substring(start, start + windowSize);

                if (currSub.equals(prevSub)) {
                    duplicateCount++;
                } else {
                    appendCompressed(compressed, prevSub, duplicateCount);

                    prevSub = currSub;
                    duplicateCount = 1;
                }
            }

            appendCompressed(compressed, prevSub, duplicateCount);
            compressed.append(s.substring(start));

            optimalCompressionSize = Math.min(optimalCompressionSize, compressed.length());

        }
        return optimalCompressionSize;
    }

    private void appendCompressed(StringBuilder compressed, String subStr, int duplicateCount) {
        if (duplicateCount > 1) {
            compressed.append(duplicateCount);
        }
        compressed.append(subStr);
    }

}
