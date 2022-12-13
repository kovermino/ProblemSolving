package com.joel.problemsolving.round2.problem3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem3Book {

    public boolean isPermutationVersion1(String first, String second) {
        if (first == null || second == null) return false;
        if (first.isEmpty() || second.isEmpty()) return false;
        if (first.length() != second.length()) return false;
        if (first.equals(second)) return true;
        String firstSort = sort(first);
        String secondSort = sort(second);
        return firstSort.equals(secondSort);
    }

    private String sort(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean isPermutationVersion2(String first, String second) {
        if (first == null || second == null) return false;
        if (first.isEmpty() || second.isEmpty()) return false;
        if (first.length() != second.length()) return false;
        if (first.equals(second)) return true;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char currentChar = first.charAt(i);
            int count = charMap.getOrDefault(currentChar, 0);
            charMap.put(currentChar, count + 1);
        }
        for (int i = 0; i < second.length(); i++) {
            char currentChar = second.charAt(i);
            int count = charMap.getOrDefault(currentChar, 0);
            charMap.put(currentChar, count - 1);
        }

        return !charMap.values().stream().anyMatch(count -> count != 0);
    }
}
