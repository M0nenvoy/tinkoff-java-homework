package edu.project2;

public record Coord(int x, int y) {
    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    Direction relation(Coord other) {
        Direction ret = null;
        if (this.x() < other.x()) {
            ret = Coord.Direction.RIGHT;
        }

        if (this.x() > other.x()) {
            ret = Coord.Direction.LEFT;
        }

        if (this.y() > other.y()) {
            ret = Coord.Direction.UP;
        }

        if (this.y() < other.y()) {
            ret = Coord.Direction.DOWN;
        }

        return ret;
    }
}
