package edu.project2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {
    private final int width;
    private final int height;
    private final Map<Coord, Cell> cells;

    Maze(int width, int height, Map<Coord, Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new HashMap<>(width * height);

        for (int y = 0; y < this.height; ++y) {
            for (int x = 0; x < this.width; ++x) {
                setCell(
                    new Coord(x, y),
                    new Cell(Cell.Pass.NO, Cell.Pass.NO, Cell.Pass.NO, Cell.Pass.NO)
                );
            }
        }
    }

    public List<Coord> getNeighbors(Coord c) {
        var neighbors = new ArrayList<Coord>();

        var spaceLeft = c.x() > 0;
        var spaceRight = c.x() < width - 1;
        var spaceTop = c.y() > 0;
        var spaceBot = c.y() < height - 1;

        if (spaceLeft) {
            neighbors.add(new Coord(c.x() - 1, c.y()));
        }

        if (spaceRight) {
            neighbors.add(new Coord(c.x() + 1, c.y()));
        }

        if (spaceTop) {
            neighbors.add(new Coord(c.x(), c.y() - 1));
        }

        if (spaceBot) {
            neighbors.add(new Coord(c.x(), c.y() + 1));
        }

        return neighbors;
    }

    public List<Coord> getPassages(Coord c) {
        var neighbors = new ArrayList<Coord>();

        var spaceLeft = c.x() > 0;
        var spaceRight = c.x() < width - 1;
        var spaceTop = c.y() > 0;
        var spaceBot = c.y() < height - 1;

        if (spaceLeft && getCell(c).left() == Cell.Pass.YES) {
            neighbors.add(new Coord(c.x() - 1, c.y()));
        }

        if (spaceRight && getCell(c).right() == Cell.Pass.YES) {
            neighbors.add(new Coord(c.x() + 1, c.y()));
        }

        if (spaceTop && getCell(c).up() == Cell.Pass.YES) {
            neighbors.add(new Coord(c.x(), c.y() - 1));
        }

        if (spaceBot && getCell(c).down() == Cell.Pass.YES) {
            neighbors.add(new Coord(c.x(), c.y() + 1));
        }

        return neighbors;
    }

    public void makePassage(Coord from, Coord to) {
        var cFrom = this.cells.get(from);
        var cTo = this.cells.get(to);
        switch (from.relation(to)) {
            case DOWN -> {
                this.setCell(from, cFrom.addDirection(Coord.Direction.DOWN));
                this.setCell(to, cTo.addDirection(Coord.Direction.UP));
                break;
            }
            case UP -> {
                this.setCell(from, cFrom.addDirection(Coord.Direction.UP));
                this.setCell(to, cTo.addDirection(Coord.Direction.DOWN));
                break;
            }
            case RIGHT -> {
                this.setCell(from, cFrom.addDirection(Coord.Direction.RIGHT));
                this.setCell(to, cTo.addDirection(Coord.Direction.LEFT));
                break;
            }
            case LEFT -> {
                this.setCell(from, cFrom.addDirection(Coord.Direction.LEFT));
                this.setCell(to, cTo.addDirection(Coord.Direction.RIGHT));
                break;
            }
            default -> throw new IllegalStateException("Не реализовано");
        }
    }

    public void setCell(Coord coord, Cell cell) {
        this.cells.put(coord, cell);
    }

    public Map<Coord, Cell> getCells() {
        return cells;
    }

    public Cell getCell(Coord coord) {
        return this.cells.get(coord);
    }

    public Cell getCell(int x, int y) {
        return getCell(new Coord(x, y));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
