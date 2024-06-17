package org.kakao21;

public class P1_1_New_Id_Recommendation {
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
        if (new_id.startsWith(".")) {
            new_id = new_id.replaceFirst("\\.", "");
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5.
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 7.
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
