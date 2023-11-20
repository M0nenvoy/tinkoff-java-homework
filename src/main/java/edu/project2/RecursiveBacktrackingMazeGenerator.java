package edu.project2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RecursiveBacktrackingMazeGenerator implements MazeGenerator {
    private static final int START_X = 0;
    private static final int START_Y = 0;

    @Override
    public Maze gen(int width, int height) {
        var maze = new Maze(width, height);
        recursiveBuild(new Coord(START_X, START_Y), maze, new HashSet<>());
        return maze;
    }

    private void recursiveBuild(Coord coord, Maze m, Set<Coord> seen) {
        seen.add(coord);

        var neighbors = m.getNeighbors(coord);
        Collections.shuffle(neighbors);
        for (var n : neighbors) {
            if (seen.contains(n)) {
                continue;
            }

            seen.add(n);
            m.makePassage(coord, n);
            recursiveBuild(n, m, seen);
        }
    }
}
