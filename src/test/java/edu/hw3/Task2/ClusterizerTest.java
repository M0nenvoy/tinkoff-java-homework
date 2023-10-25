package edu.hw3.Task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClusterizerTest {
    @DisplayName("clusterize - Три пары скобок")
    @Test
    void clusterize3Pairs() {
        Assertions
            .assertThat(Clusterizer.clusterize("()()()"))
            .containsExactly("()", "()", "()");
    }

    @DisplayName("clusterize - Одна большая конструкция")
    @Test
    void clusterizeOneBigThing() {
        Assertions
            .assertThat(Clusterizer.clusterize("((()))"))
            .containsExactly("((()))");
    }

    @DisplayName("clusterize - Несколько конструкций разного размера")
    @Test
    void clusterizeMultipleDifferentThings() {
        Assertions
            .assertThat(Clusterizer.clusterize("((()))(())()()(()())"))
            .containsExactly("((()))", "(())", "()", "()", "(()())");
    }

    @DisplayName("clusterize - Несбалансированные класетры исключаются (в начале)")
    @Test
    void clusterizeUnbalancedClustersAreRemovedInAtBeginning() {
        Assertions
            .assertThat(Clusterizer.clusterize("))()()"))
            .containsExactly("()", "()");
    }

    @DisplayName("clusterize - Несбалансированные кластеры исключаются (в конце)")
    @Test
    void clusterizeUnbalancedClustersAreRemovedInEnd() {
        Assertions
            .assertThat(Clusterizer.clusterize("()()(("))
            .containsExactly("()", "()");
    }

    @DisplayName("clusterize - Несбалансированные кластеры исключаются (в середине)")
    @Test
    void clusterizeUnbalancedClustersAreRemovedInMiddle() {
        Assertions
            .assertThat(Clusterizer.clusterize("())()"))
            .containsExactly("()", "()");
    }

    @DisplayName("clusterize - При null строке бросается исключение")
    @Test
    void clusterizeNullStringException() {
        Assertions.assertThatThrownBy(() -> Clusterizer.clusterize(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("clusterize - При пустой строке бросается исключение")
    @Test
    void clusterizeEmptyStringException() {
        Assertions.assertThatThrownBy(() -> Clusterizer.clusterize(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("clusterize - Строка содержит некорректные символы")
    @Test
    void clusterizeIllegalSymbolsException() {
        Assertions.assertThatThrownBy(() -> Clusterizer.clusterize("((f))"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
