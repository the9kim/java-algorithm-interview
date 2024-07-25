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
        for (int i = 0; i < pages.length; i++) {
            word = word.toLowerCase();
            String html = pages[i].toLowerCase();

            // url
            String urlRegex = "<meta property=\"og:url\" content=\"(.*?)\"";
            Matcher matcher = Pattern.compile(urlRegex).matcher(html);
            if (matcher.find()) {
                String url = matcher.group(1);
                urlMap.put(i, url);
                linkedPageMap.putIfAbsent(url, new ArrayList<>());
            }

            // link
            String linkRegex = "<a href=\"(.*?)\"";
            matcher = Pattern.compile(linkRegex).matcher(html);
            int linkCount = 0;
            while (matcher.find()) {
                String link = matcher.group(1);
                linkCount++;
                linkedPageMap.putIfAbsent(link, new ArrayList<>());
                linkedPageMap.get(link).add(i);
            }
            exLinkMap.put(i, linkCount);

            // word
            // look-behind and look-ahead pattern
            String wordRegex = "(?<![a-zA-Z])" + Pattern.quote(word) + "(?![a-zA-Z])";
            matcher = Pattern.compile(wordRegex).matcher(html);

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

}
