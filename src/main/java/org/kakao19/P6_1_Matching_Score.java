package org.kakao19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class P6_1_Matching_Score {

    Map<Integer, String> urlMap = new HashMap<>();
    Map<Integer, Integer> basicScoreMap = new HashMap<>();
    Map<Integer, Integer> exLinkMap = new HashMap<>();
    Map<String, List<Integer>> linkedPageMap = new HashMap<>();


    /**
     * 1. Extract information from html using Regex
     * 2. Calculate the matching scores
     * 3. identify the highest one
     */
    public int solution(String word, String[] pages) {
        int n = pages.length;

        String[] urls = new String[n];
        int[] basicScores = new int[n];
        Map<Integer, List<String>> links = new HashMap<>();
        double[] matchingScores = new double[n];

        // 1. Parse the html pages
        word = word.toLowerCase();
        Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"/>");
        Pattern linkPattern = Pattern.compile("<a href=\"(.*?)\">");
        Pattern wordPattern = Pattern.compile("(?<![a-zA-Z])" + Pattern.quote(word) + "(?![a-zA-Z])");

        for (int i = 0; i < n; i++) {
            String page = pages[i].toLowerCase();

            // url
            Matcher matcher = urlPattern.matcher(page);
            if (matcher.find()) {
                urls[i] = matcher.group(1);
            }

            // links
            matcher = linkPattern.matcher(page);
            links.putIfAbsent(i, new ArrayList<>());
            while (matcher.find()) {
                links.get(i).add(matcher.group(1));
            }

            // basic score
            matcher = wordPattern.matcher(page);
            basicScores[i] = (int) matcher.results().count();
        }

        // 2. Calculate the Matching score
        for (int i = 0; i < n; i++) {
            String url = urls[i];
            double score = basicScores[i];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                List<String> linkList = links.get(j);
                if (linkList.contains(url)) {
                    score += (double) basicScores[j] / linkList.size();
                }
            }
            matchingScores[i] = score;
        }

        // 3. Find the index with the maximum matching score
        return IntStream.range(0, n)
                .boxed()
                .max(Comparator.comparingDouble(i -> matchingScores[i]))
                .orElse(0);

    }

}
