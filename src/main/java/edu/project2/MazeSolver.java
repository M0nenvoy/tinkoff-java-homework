package edu.project2;

import java.util.List;

public interface MazeSolver {
    List<Coord> solve(Maze maze, Coord from, Coord to) throws MazeException;
}
