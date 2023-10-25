package edu.project1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HiddenWordTest {
    @DisplayName("HiddenWord_reveal - Длинна слова сохраняется")
    @Test
    void hiddenWordPreserveLength() {
        var hw = new HiddenWord("слово");
        Assertions
            .assertThat(hw.toString())
            .hasSameSizeAs("слово");
    }

    @DisplayName("HiddenWord_reveal - раскрытие буквы")
    @Test
    void hiddenWordRevealLetter() {
        var hw = new HiddenWord("слово");
        hw.reveal('в');
        Assertions
            .assertThat(hw.toString().toCharArray())
            .containsExactly('*', '*', '*', 'в', '*');
    }

    @DisplayName("HiddenWord_reveal - раскрытие нескольких букв")
    @Test
    void hiddenWordRevealMultipleLetters() {
        var hw = new HiddenWord("слово");
        hw.reveal('о');
        Assertions
            .assertThat(hw.toString().toCharArray())
            .containsExactly('*', '*', 'о', '*', 'о');
    }

    @DisplayName("HiddenWord_reveal - Возвращение HIT")
    @Test
    void hiddenWordHit() {
        var hw = new HiddenWord("слово");
        Assertions
            .assertThat(hw.reveal('л'))
            .isEqualTo(RevealStatus.HIT);
    }

    @DisplayName("HiddenWord_reveal - Возвращение MISS")
    @Test
    void hiddenWordMiss() {
        var hw = new HiddenWord("слово");
        Assertions
            .assertThat(hw.reveal('e'))
            .isEqualTo(RevealStatus.MISS);
    }

    @DisplayName("HiddenWord_reveal - Возвращение ALREADY_KNOWN")
    @Test
    void hiddenWordAlreadyKnown() {
        var hw = new HiddenWord("слово");
        hw.reveal('л');
        Assertions
            .assertThat(hw.reveal('л'))
            .isEqualTo(RevealStatus.ALREADY_KNOWN);
    }

    @DisplayName("HiddenWord_isAllRevealed - Слово полностью определено")
    @Test
    void hiddenWordIsAllRevealedTrue() {
        var hw = new HiddenWord("ааааа");
        hw.reveal('а');
        Assertions
            .assertThat(hw.isAllRevealed()).isTrue();
    }

    @DisplayName("HiddenWord - Строка null")
    @Test
    void hiddenWordNullString() {
        Assertions.assertThatThrownBy(() -> new HiddenWord(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("HiddenWord - Пустая строка")
    @Test
    void hiddenWordEmptyString() {
        Assertions.assertThatThrownBy(() -> new HiddenWord("")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("HiddenWord - Недопустимый символ")
    @Test
    void hiddenWordIllegalChar() {
        Assertions.assertThatThrownBy(() -> new HiddenWord("аа*")).isInstanceOf(IllegalArgumentException.class);
    }
}
