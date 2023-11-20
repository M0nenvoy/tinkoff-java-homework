package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveBacktrackingMazeSolver implements MazeSolver {
    @Override
    public List<Coord> solve(Maze maze, Coord from, Coord to) throws MazeException {
        validateCoord(from, maze);
        validateCoord(to, maze);
        var seen = new HashSet<Coord>();
        var path = new ArrayList<Coord>();

        var result = dfs(maze, from, to, seen, path);

        if (result != Result.SUCCESS) {
            throw new MazeException("Невозможно дойти до цели");
        }

        return path;
    }

    private Result dfs(Maze maze, Coord from, Coord to, Set<Coord> seen, List<Coord> path) {
        if (from.equals(to)) {
            path.add(from);
            return Result.SUCCESS;
        }

        seen.add(from);

        var passages = maze.getPassages(from);
        for (var n : passages) {
            if (seen.contains(n)) {
                continue;
            }

            if (dfs(maze, n, to, seen, path) == Result.SUCCESS) {
                path.add(from);
                return Result.SUCCESS;
            }
        }

        return Result.FAIL;
    }

    private enum Result {
        FAIL, SUCCESS
    }

    private void validateCoord(Coord coord, Maze maze) throws MazeException {
        if (coord.x() >= maze.getWidth() || coord.x() < 0) {
            throw new MazeException("Координата х вне допустимого");
        }

        if (coord.y() >= maze.getHeight() || coord.y() < 0) {
            throw new MazeException("Координата y вне допустимого");
        }
    }
}
