package org.kakao19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P6_1_Matching_Score {

    Map<Integer, String> urlMap = new HashMap<>();
    Map<Integer, Integer> basicScoreMap = new HashMap<>();
    Map<Integer, Integer> exLinkMap = new HashMap<>();
    Map<String, List<Integer>> linkedPageMap = new HashMap<>();


    /**
     * 1. Extract information from html using Regex
     * 2. Calculate the matching scores and identify the highest one
     */
    public int solution(String word, String[] pages) {
        // 1.
        Matcher matcher;
        for (int i = 0; i < pages.length; i++) {
            word = word.toLowerCase();
            String html = pages[i].toLowerCase();

            // url
            int headStart = html.indexOf("<head>");
            int headEnd = html.indexOf("</head>", headStart);
            String head = html.substring(headStart + 6, headEnd);
            String urlRegex = "<meta property=\"og:url\" content=\"(.*?)\"";
            matcher = getMatcher(urlRegex, head);
            if (matcher.find()) {
                String url = matcher.group(1);
                urlMap.put(i, url);
                linkedPageMap.putIfAbsent(url, new ArrayList<>());
            }

            // link
            String linkRegex = "<a href=\"(.*?)\"";
            matcher = getMatcher(linkRegex, html);
            while (matcher.find()) {
                String link = matcher.group(1);
                exLinkMap.put(i, exLinkMap.getOrDefault(i, 0) + 1);

                linkedPageMap.putIfAbsent(link, new ArrayList<>());
                linkedPageMap.get(link).add(i);
            }

            // word

            // look-behind and look-ahead pattern
            String wordRegex = "(?<![a-zA-Z])" + Pattern.quote(word) + "(?![a-zA-Z])";
            matcher = getMatcher(wordRegex, html);

            int count = 0;
            while (matcher.find()) {
                count++;
            }
            basicScoreMap.put(i, count);
        }

        // 2.
        int topScoreIdx = -1;
        double maxScore = -1;
        for (int i = 0; i < pages.length; i++) {
            int basicScore = basicScoreMap.get(i);

            double linkScore = 0;
            String url = urlMap.get(i);
            List<Integer> linkedIdx = linkedPageMap.get(url);
            for (int pageIdx : linkedIdx) {
                linkScore += (double) basicScoreMap.get(pageIdx) / exLinkMap.get(pageIdx);
            }

            double totalScore = basicScore + linkScore;
            if (totalScore > maxScore) {
                maxScore = totalScore;
                topScoreIdx = i;
            }
        }
        return topScoreIdx;

    }

    public Matcher getMatcher(String regex, String html) {
        return Pattern.compile(regex).matcher(html);
    }
}
