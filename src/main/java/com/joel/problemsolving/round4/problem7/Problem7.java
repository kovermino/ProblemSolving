package com.joel.problemsolving.round4.problem7;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 주어진 단어 리스트에서, 다른 단어들을 조합하여 만들어진 단어 중 가장 긴 단어를 찾는 프로그램을 작성하라.
 * 예:
 * 입력: cat, banana, dog, nana, walk, dogwalker
 * 출력: dogwalker
 */
public class Problem7 {
    public String findLongestCombinedWord(String[] words) {
        Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
        Arrays.sort(words, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String left = word.substring(0, i);
                String right = word.substring(i);
                if (wordSet.contains(left) && (wordSet.contains(right) || isWordBuildable(right, wordSet))) {
                    return word;
                }
            }
        }
        return null;
    }

    private boolean isWordBuildable(String word, Set<String> wordSet) {
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if(wordSet.contains(left) && (wordSet.contains(right) || isWordBuildable(right, wordSet))) {
                return true;
            }
        }
        return false;
    }
}
