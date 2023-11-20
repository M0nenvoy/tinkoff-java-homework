package edu.project2;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazePromptRenderer implements MazeRenderer {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int CELL_SIZE = 3;
    Character wall;
    Character passage;
    Character mark;

    MazePromptRenderer(Character wall, Character passage, Character mark) {
        this.wall = wall;
        this.passage = passage;
        this.mark = mark;
    }

    MazePromptRenderer() {
        this('#', '.', 'X');
    }

    @Override
    public void render(Maze maze, List<Coord> highlight) {
        for (var line : representMaze(maze, highlight)) {
            LOGGER.info(line);
        }
    }

    public List<String> representMaze(Maze maze, List<Coord> highlight) {
        var result = new ArrayList<String>(maze.getHeight() * CELL_SIZE);
        var top = new StringBuilder();
        var mid = new StringBuilder();
        var bot = new StringBuilder();
        for (int x = 0; x < maze.getWidth(); x++) {
            int y = 0;
            var r = representCell(
                maze.getCell(x, y),
                highlight.contains(new Coord(x, y)),
                highlight.contains(new Coord(x, y - 1)),
                highlight.contains(new Coord(x, y + 1)),
                highlight.contains(new Coord(x - 1, y)),
                highlight.contains(new Coord(x + 1, y))
            );
            top.append(r.top);
            mid.append(r.mid);
            bot.append(r.bot);
        }

        result.add(top.toString());
        result.add(mid.toString());
        result.add(bot.toString());

        for (int y = 1; y < maze.getHeight(); y++) {
            var midCurrent = new StringBuilder();
            var botCurrent = new StringBuilder();
            for (int x = 0; x < maze.getWidth(); x++) {
                var r = representCell(
                    maze.getCell(x, y),
                    highlight.contains(new Coord(x, y)),
                    highlight.contains(new Coord(x, y - 1)),
                    highlight.contains(new Coord(x, y + 1)),
                    highlight.contains(new Coord(x - 1, y)),
                    highlight.contains(new Coord(x + 1, y))
                );
                midCurrent.append(r.mid);
                botCurrent.append(r.bot);
            }
            result.add(midCurrent.toString());
            result.add(botCurrent.toString());
        }
        return result;
    }

    public CellRepresentation representCell(
        Cell cell,
        boolean isMarked,
        boolean aboveMarked,
        boolean belowMarked,
        boolean leftMarked,
        boolean rightMarked
    ) {
        boolean above = isMarked & aboveMarked;
        boolean below = isMarked & belowMarked;
        boolean left = isMarked & leftMarked;
        boolean right = isMarked & rightMarked;

        var top = cell.up() == Cell.Pass.YES
            ? new StringBuilder().append(wall).append(above ? mark : passage).append(wall)
            : new StringBuilder().repeat(wall, CELL_SIZE);

        String mid = String.valueOf(cell.left() == Cell.Pass.YES ? (left ? mark : passage) : wall)
            + (isMarked ? mark : passage)
            + (cell.right() == Cell.Pass.YES ? (right ? mark : passage) : wall);

        var bot = cell.down() == Cell.Pass.YES
            ? new StringBuilder().append(wall).append(below ? mark : passage).append(wall)
            : new StringBuilder().repeat(wall, CELL_SIZE);

        return new CellRepresentation(top.toString(), mid, bot.toString());
    }

    public CellRepresentation representCell(Cell cell, boolean marked) {
        return representCell(cell, marked, false, false, false, false);
    }

    public CellRepresentation representCell(Cell cell) {
        return representCell(cell, false);
    }

    public record CellRepresentation(
        String top,
        String mid,
        String bot
    ) {

    }
}
