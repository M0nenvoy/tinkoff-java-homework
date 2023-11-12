package edu.hw5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task6Test {
    @DisplayName("Строка является подпоследовательностью")
    @ParameterizedTest
    @CsvSource({"achfdbaabgabcaabg,abc", "abc,abc"})
    void isSubsequence(String haystack, String needle) {
        assertThat(Task6.isSubsequence(haystack, needle)).isTrue();
    }

    @DisplayName("Строка не является подпоследовательностью")
    @ParameterizedTest
    @CsvSource({"subsequence,not", "aabb,ac"})
    void isNotSubsequence(String haystack, String needle) {
        assertThat(Task6.isSubsequence(haystack, needle)).isFalse();
    }
}
