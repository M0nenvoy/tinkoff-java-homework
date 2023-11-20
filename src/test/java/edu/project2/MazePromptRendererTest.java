package edu.project2;

import static org.assertj.core.api.Assertions.*;
import static edu.project2.Coord.Direction.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

public class MazePromptRendererTest {
    MazePromptRenderer renderer;

    @BeforeEach
    void initRenderer() {
        this.renderer = new MazePromptRenderer('#', '.', 'X');
    }

    @DisplayName("Репрезентация прохода вверх-вправо")
    @Test
    void representationUpRight() {
        assertThat(renderer.representCell(Cell
            .fromDirection(Coord.Direction.UP)
            .addDirection(Coord.Direction.RIGHT)))
            .extracting(
                e -> tuple(
                    e.top(),
                    e.mid(),
                    e.bot()
                )
            ).isEqualTo(
                tuple(
                    "#.#",
                    "#..",
                    "###"
                )
            );
    }

    @DisplayName("Репрезентация прохода вверх-вправо-влево")
    @Test
    void representationUpRightLeft() {
        assertThat(renderer.representCell(Cell
            .fromDirection(Coord.Direction.UP)
            .addDirection(Coord.Direction.RIGHT)
            .addDirection(Coord.Direction.LEFT)))
            .extracting(
                e -> tuple(
                    e.top(),
                    e.mid(),
                    e.bot()
                )
            ).isEqualTo(
                tuple(
                    "#.#",
                    "...",
                    "###"
                )
            );
    }

    @DisplayName("Репрезентация прохода во все стороны")
    @Test
    void representationAllWay() {
        assertThat(renderer.representCell(Cell
            .fromDirection(Coord.Direction.UP)
            .addDirection(Coord.Direction.DOWN)
            .addDirection(Coord.Direction.RIGHT)
            .addDirection(Coord.Direction.LEFT)))
            .extracting(
                e -> tuple(
                    e.top(),
                    e.mid(),
                    e.bot()
                )
            ).isEqualTo(
                tuple(
                    "#.#",
                    "...",
                    "#.#"
                )
            );
    }

    @DisplayName("Рендеринг продолговатого лабиринта")
    @Test
    void renderNarrowMaze() {
        var maze = new Maze(3, 2, Map.of(
            new Coord(0, 0), Cell.fromDirection(UP).addDirection(RIGHT).addDirection(DOWN),
            new Coord(1, 0), Cell.fromDirection(RIGHT).addDirection(LEFT),
            new Coord(2, 0), Cell.fromDirection(DOWN).addDirection(LEFT),
            new Coord(0, 1), Cell.fromDirection(RIGHT).addDirection(UP),
            new Coord(1, 1), Cell.fromDirection(LEFT).addDirection(RIGHT),
            new Coord(2, 1), Cell.fromDirection(LEFT).addDirection(UP)
        ));

        assertThat(renderer.representMaze(maze, List.of(
            new Coord(1, 1),
            new Coord(0, 0),
            new Coord(0, 1)
        )))
            .containsExactly(
                "#.#######",
                "#X......#",
                "#X#####.#",
                "#XXXX...#",
                "#########"
            );
    }
}
