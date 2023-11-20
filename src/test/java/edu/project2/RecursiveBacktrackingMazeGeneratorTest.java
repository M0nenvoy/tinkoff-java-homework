package edu.project2;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecursiveBacktrackingMazeGeneratorTest {
    @DisplayName("Генерация лабиринта")
    @Test
    void gen() {
        assertThat(new RecursiveBacktrackingMazeGenerator().gen(9, 9))
            .satisfies(
                m -> assertThat(m.getCells()).allSatisfy((k, v) -> {
                    assertThat(v).isNotEqualTo(new Cell(Cell.Pass.NO, Cell.Pass.NO, Cell.Pass.NO, Cell.Pass.NO));
                })
            );
    }
}
