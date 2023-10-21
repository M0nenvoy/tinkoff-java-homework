package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task5Test {
    Task5 task;

    @BeforeEach
    void initializeTask() {
        this.task = new Task5();
    }

    @DisplayName("Разбиение на массив цифр - Happy Path")
    @Test
    void splitDigitsHappyPath() {
        Assertions
            .assertThat(task.splitDigits(12345)).containsExactly(new int[] {1, 2, 3, 4, 5});
    }

    @DisplayName("Разбиение на массив цифр - Отрицательное число")
    @Test
    void splitDigitsNegativeValue() {
        Assertions
            .assertThat(task.splitDigits(-12345)).containsExactly(new int[] {1, 2, 3, 4, 5});
    }

    @DisplayName("Разбиение на массив цифр - Ноль")
    @Test
    void splitDigitsZero() {
        Assertions
            .assertThat(task.splitDigits(0)).contains(new int[] {0});
    }

    @DisplayName("isPalindrome - Массив. Истина чет")
    @Test
    void isPalindromeTrueEven() {
        Assertions
            .assertThat(task.isPalindrome(new int[] {1, 2, 2, 1})).isTrue();
    }

    @DisplayName("isPalindrome - Массив. Истина нечет")
    @Test
    void isPalindromeTrueOdd() {
        Assertions
            .assertThat(task.isPalindrome(new int[] {1, 2, 1})).isTrue();
    }

    @DisplayName("isPalindrome - Массив. Ложь чет")
    @Test
    void isPalindromeFalseEven() {
        Assertions
            .assertThat(task.isPalindrome(new int[] {1, 2, 5, 6, 2, 1})).isFalse();
    }

    @DisplayName("isPalindrome - Массив. Ложь нечет")
    @Test
    void isPalindromeFalseOdd() {
        Assertions
            .assertThat(task.isPalindrome(new int[] {1, 2, 5, 7, 6, 2, 1})).isFalse();
    }

    @DisplayName("isPalindrome - Параметры")
    @ParameterizedTest
    @ValueSource(ints = {11, 44, 5665})
    void isPalindromeParameter(int x) {
        Assertions
            .assertThat(task.isPalindrome(x)).isTrue();
    }

    @DisplayName("mergeDigits - Happy Path")
    @Test
    void mergeDigitsHappyPath() {
        Assertions
            .assertThat(task.mergeDigits(new int[] {1, 2, 3, 4, 5})).isEqualTo(12345);
    }

    @DisplayName("getDescendant - Чет")
    @Test
    void getDescendantEven() {
        Assertions
            .assertThat(task.getDescendant(new int[] {1, 2, 3, 4}))
            .containsExactly(new int[] {3, 7});
    }

    @DisplayName("getDescendant - Нечет")
    @Test
    void getDescendantOdd() {
        Assertions
            .assertThat(task.getDescendant(new int[] {1, 2, 3, 4, 5}))
            .containsExactly(new int[] {3, 7, 5});
    }

    @DisplayName("getDescendant - Массив null")
    @Test
    void getDescendantNull() {
        Assertions.assertThatThrownBy(() -> task.getDescendant(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getDescendant - Число больше 9 в результате")
    @Test
    void getDescendantMoreThan10() {
        Assertions
            .assertThat(task.getDescendant(new int[] {5, 6})).containsExactly(new int[] {1, 1});
    }

    @DisplayName("getDescendant - Меньше двух элементов в массиве")
    @Test
    void getDescendantLessThan2() {
        Assertions.assertThatThrownBy(() -> task.getDescendant(new int[] {0}))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("isPalindromeDescendant - Истина")
    @ParameterizedTest
    @ValueSource(ints = {11211230, 13001120, 23336014, 11})
    void isPalindromeDescendantTrue(int x) {
        Assertions
            .assertThat(task.isPalindromeDescendant(x)).isTrue();
    }

    @DisplayName("isPalindromeDescendant - Ложь")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 124, 1234})
    void isPalindromeDescendantFalse(int x) {
        Assertions
            .assertThat(task.isPalindromeDescendant(x)).isFalse();
    }
}
