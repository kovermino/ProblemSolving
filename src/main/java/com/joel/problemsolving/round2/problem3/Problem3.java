package com.joel.problemsolving.round2.problem3;

/**
 * 문자열 2개를 입력받아 그 중 하나가 다른 하나의 순열(permutation)인지 확인하는 메서드를 작성하라.
 */
public class Problem3 {
    public boolean isPermutation(String first, String second) {
        if(first == null || second == null) return false;
        if(first.isEmpty() || second.isEmpty()) return false;
        if(first.length() != second.length()) return false;
        if(first.equals(second)) return true;
        String rotated = first;
        for(int i=0;i<first.length();i++) {
            rotated = rotate1Step(rotated);
            if(rotated.equals(second)) return true;
        }
        return false;
    }

    private String rotate1Step(String input) {
        if(input == null || input.isEmpty()) return input;
        return input.charAt(input.length()-1) + "" + input.substring(0, input.length()-1);
    }
}
