package com.joel.problemsolving.round5.problem9;

import java.util.*;

/**
 * 사전에 등장하고 길이가 같은 두 단어가 주어졌을 때, 한 번에 글자 하나만 바꾸어 한 단어를 다른 단어로 변환하는 메서드를 작성하라. 변환 과정에서 만들어지는 각 단어도 사전에 있는 단어여야 한다.
 * 예:
 * 입력: DAMP, LIKE
 * 출력: DAMP -> LAMP -> LIMP -> LIME -> LIKE
 * <p>
 * [알고리즘]
 * 1. start부터 시작
 * 2. 현재 단어에서 한 글자만 바뀐 단어들을 사전에서 전부 찾는다.
 * 3. end와 같지 않으면, 방문한 것으로 표시하고 탐색대상 단어로 지정하고 back track으로 저장한다.
 * 4. end와 같으면, back track을 거슬러 올라가 경로를 리턴한다.
 */
public class Problem9 {
    public List<String> getConversionPath(String start, String end, Set<String> dictionary) {
        if (!dictionary.contains(start) || !dictionary.contains(end)) return null;
        if (start.equals(end)) return Arrays.asList(start);

        Queue<String> targetQueue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        Map<String, String> backTrackMap = new TreeMap<>();

        targetQueue.add(start);
        visitedSet.add(start);

        while (!targetQueue.isEmpty()) {
            String target = targetQueue.poll();
            Set<String> oneCharDiffers = getOneCharDifferentWords(target, dictionary);
            for (String oneCharDifferentWord : oneCharDiffers) {
                if (oneCharDifferentWord.equals(end)) {
                    LinkedList<String> result = new LinkedList<>();
                    result.add(oneCharDifferentWord);

                    String previousWord = target;
                    while (previousWord != null) {
                        result.add(0, previousWord);
                        previousWord = backTrackMap.get(previousWord);
                    }
                    return result;
                } else {
                    if (!visitedSet.contains(oneCharDifferentWord)) {
                        targetQueue.add(oneCharDifferentWord);
                        visitedSet.add(oneCharDifferentWord);
                        backTrackMap.put(oneCharDifferentWord, target);
                    }
                }
            }
        }
        return null;
    }

    private Set<String> getOneCharDifferentWords(String word, Set<String> dictionary) {
        Set<String> result = new HashSet<>();
        for (String dictionaryWord : dictionary) {
            if (isOneCharDifferent(word, dictionaryWord)) {
                result.add(dictionaryWord);
            }
        }
        return result;
    }

    private boolean isOneCharDifferent(String target, String comparing) {
        if (target == null && comparing == null) return true;
        if (target == null || comparing == null) return false;
        if (target.length() != comparing.length()) return false;

        int differentCharCount = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != comparing.charAt(i)) differentCharCount++;
        }
        return differentCharCount == 1;
    }
}
