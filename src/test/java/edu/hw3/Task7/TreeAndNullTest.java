package edu.hw3.Task7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

public class TreeAndNullTest {
    @DisplayName("Дерево и null")
    @Test
    void treeAndNull() {
        TreeMap<String, String> tree = new TreeMap<>(
            TreeMapComparator.get()
        );

        tree.put(null, "Test");

        Assertions.assertThat(tree.containsKey(null)).isTrue();
    }
}
