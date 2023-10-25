package edu.hw3.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AtBashCipherTest {
    @DisplayName("atbash - Happy Path")
    @ParameterizedTest
    @CsvSource({
        "aaa,zzz", "Hello world!,Svool dliow!",
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler," +
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
    })
    void atbashHappyPath(String source, String expected) {
        Assertions
            .assertThat(AtBashCipher.atbash(source)).isEqualTo(expected);
    }

    @DisplayName("atbash - Символы вне латинского алфавита остаются неизмененными")
    @ParameterizedTest
    @CsvSource({
        "1234,1234", "Россия,Россия", "!!..((,!!..(("
    })
    void atbashNonLatinNotModified(String source, String expected) {
        Assertions
            .assertThat(AtBashCipher.atbash(source)).isEqualTo(expected);
    }

    @DisplayName("atbash - Бросается исключение при null строке")
    @Test
    void atbasNullStringThrows() {
        Assertions.assertThatThrownBy(() -> AtBashCipher.atbash(null));
    }

    @DisplayName("atbash - Бросается исключение при пустой строке")
    @Test
    void atbashEmptyStringThrows() {
        Assertions.assertThatThrownBy(() -> AtBashCipher.atbash(""));
    }
}
