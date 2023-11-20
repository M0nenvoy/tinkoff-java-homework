package edu.project2;

import static edu.project2.Coord.Direction.DOWN;
import static edu.project2.Coord.Direction.LEFT;
import static edu.project2.Coord.Direction.RIGHT;
import static edu.project2.Coord.Direction.UP;
import static org.assertj.core.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class RecursiveBacktrackingMazeSolverTest {
    RecursiveBacktrackingMazeSolver solver;

    @BeforeEach
    void initSolver() {
        this.solver = new RecursiveBacktrackingMazeSolver();
    }

    @DisplayName("Невозможно дойти до цели")
    @Test
    void impossibleToReach() {
        var maze = new Maze(3, 3);
        maze.makePassage(new Coord(0, 0), new Coord(1, 0));
        maze.makePassage(new Coord(0, 0), new Coord(2, 0));

        assertThatThrownBy(() -> solver.solve(maze, new Coord(0, 0), new Coord(0, 1)))
            .isInstanceOf(MazeException.class);
    }

    @DisplayName("Нахождение маршрута")
    @Test
    void findPath() {
        /*
         * "#########"
         * "#S      #"
         * "#.#######"
         * "#...E   #"
         * "#########"
         */
        var maze = new Maze(3, 2, Map.of(
            new Coord(0, 0), Cell.fromDirection(RIGHT).addDirection(DOWN),
            new Coord(1, 0), Cell.fromDirection(RIGHT).addDirection(LEFT),
            new Coord(2, 0), Cell.fromDirection(LEFT),
            new Coord(0, 1), Cell.fromDirection(RIGHT).addDirection(UP),
            new Coord(1, 1), Cell.fromDirection(LEFT).addDirection(RIGHT),
            new Coord(2, 1), Cell.fromDirection(LEFT).addDirection(UP)
        ));

        assertThatCode(() -> assertThat(solver.solve(maze, new Coord(0, 0), new Coord(2, 1)))
            .containsExactly(
                new Coord(2, 1),
                new Coord(1, 1),
                new Coord(0, 1),
                new Coord(0, 0)
            )).doesNotThrowAnyException();
    }

    @DisplayName("Нахождение маршрута вне допустимых границ")
    @Test
    void outOfBoundsSolve() {
        var maze = new Maze(9, 9);
        assertThatThrownBy(() -> solver.solve(maze, new Coord(100, 100), new Coord(-1, -1)));
    }
}
