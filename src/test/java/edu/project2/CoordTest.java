package edu.project2;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoordTest {
    @DisplayName("Coord вправо")
    @Test
    void coordRight() {
        assertThat(new Coord(1, 0).relation(new Coord(2, 0)))
            .isEqualTo(Coord.Direction.RIGHT);
    }

    @DisplayName("Coord влево")
    @Test
    void coordLeft() {
        assertThat(new Coord(2, 0).relation(new Coord(1, 0)))
            .isEqualTo(Coord.Direction.LEFT);
    }

    @DisplayName("Coord вниз")
    @Test
    void coordDown() {
        assertThat(new Coord(0, 1).relation(new Coord(0, 2)))
            .isEqualTo(Coord.Direction.DOWN);
    }

    @DisplayName("Coord вверх")
    @Test
    void coordUp() {
        assertThat(new Coord(0, 2).relation(new Coord(0, 1)))
            .isEqualTo(Coord.Direction.UP);
    }
}
