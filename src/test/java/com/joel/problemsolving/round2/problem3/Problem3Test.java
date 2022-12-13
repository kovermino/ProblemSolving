package com.joel.problemsolving.round2.problem3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    private Problem3 sut = new Problem3();

    @ParameterizedTest
    @MethodSource(value = "permutations")
    void isPermutation_서로_순열인_문자열을_입력받으면_true를_리턴한다(String[] permutationPair) {
        String first = permutationPair[0];
        String second = permutationPair[1];


        assertTrue(sut.isPermutation(first, second));
    }

    @ParameterizedTest
    @MethodSource(value = "notPermutations")
    void isPermutation_순열이_아닌_문자열을_입력받으면_false를_리턴한다(String[] notPermutationPair) {
        String first = notPermutationPair[0];
        String second = notPermutationPair[1];


        assertFalse(sut.isPermutation(first, second));
    }

    @ParameterizedTest
    @MethodSource(value = "includeNulls")
    void isPermutation_null이_입력되면_false를_리턴한다(String[] nullPair) {
        String first = nullPair[0];
        String second = nullPair[1];


        assertFalse(sut.isPermutation(first, second));
    }

    @ParameterizedTest
    @MethodSource(value = "includeEmptyStrings")
    void isPermutation_빈_문자열이_입력되면_false를_리턴한다(String[] emptyPair) {
        String first = emptyPair[0];
        String second = emptyPair[1];


        assertFalse(sut.isPermutation(first, second));
    }

    public static Stream<Arguments> permutations() {
        return Stream.of(
                Arguments.of((Object) new String[]{"permutation", "permutation"}),
                Arguments.of((Object) new String[]{"permutation", "npermutatio"}),
                Arguments.of((Object) new String[]{"permutation", "onpermutati"}),
                Arguments.of((Object) new String[]{"intelligence", "eintelligenc"}),
                Arguments.of((Object) new String[]{"intelligence", "ceintelligen"}),
                Arguments.of((Object) new String[]{"i", "i"})
        );
    }

    public static Stream<Arguments> notPermutations() {
        return Stream.of(
                Arguments.of((Object) new String[]{"permu", "npermutatio"}),
                Arguments.of((Object) new String[]{"permutatio", "onpermutat"}),
                Arguments.of((Object) new String[]{"i", "j"})
        );
    }

    public static Stream<Arguments> includeNulls() {
        return Stream.of(
                Arguments.of((Object) new String[]{null, "npermutatio"}),
                Arguments.of((Object) new String[]{"permutation", null}),
                Arguments.of((Object) new String[]{null, null})
        );
    }

    public static Stream<Arguments> includeEmptyStrings() {
        return Stream.of(
                Arguments.of((Object) new String[]{"", "npermutatio"}),
                Arguments.of((Object) new String[]{"permutation", ""}),
                Arguments.of((Object) new String[]{"", ""})
        );
    }
}