package org.kakao21;

public class P1_2_New_Id_Recommendation extends P1_1_New_Id_Recommendation {
    /**
     * 1. Convert the input string to lowercase
     * 2. Remove undefined characters using REGEX
     * 3. Remove continuous dots
     * 4. Remove dots at the beginning or end of the word
     * 5. If the input is empty, assign 'a' to it
     * 6. if the length of the input is over 15, remove characters which is out of range.
     * if the last character is a dot, remove it
     * 7. If the length of the input is less 3, attach the last character of the input at the end of it until the size become 3.
     */
    public String solution(String new_id) {

        // 1.
        new_id = new_id.toLowerCase();

        // 2.
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3.
        new_id = new_id.replaceAll("\\.+", ".");

        // 4.
        StringBuilder sb = new StringBuilder(new_id);
        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() -1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 5.
        if (sb.length() == 0) {
            sb.append('a');
        }

        // 6.
        if (sb.length() >= 16) {
            sb.setLength(15);
            if (sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }

        // 7.
        while (sb.length() > 0 && sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}
