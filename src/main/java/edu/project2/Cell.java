package edu.project2;

public record Cell(
    Pass right,
    Pass left,
    Pass down,
    Pass up
) {
    private final static String NOT_IMPLEMENTED = "Не реализовано";

    public enum Pass {
        YES, NO
    }

    public static Cell fromDirection(Coord.Direction direction) {
        return switch (direction) {
            case DOWN -> new Cell(Pass.NO, Pass.NO, Pass.YES, Pass.NO);
            case UP -> new Cell(Pass.NO, Pass.NO, Pass.NO, Pass.YES);
            case RIGHT -> new Cell(Pass.YES, Pass.NO, Pass.NO, Pass.NO);
            case LEFT -> new Cell(Pass.NO, Pass.YES, Pass.NO, Pass.NO);
            default -> throw new IllegalArgumentException(NOT_IMPLEMENTED);
        };
    }

    public Cell addDirection(Coord.Direction direction) {
        return switch (direction) {
            case DOWN -> new Cell(this.right, this.left, Pass.YES, this.up);
            case UP -> new Cell(this.right, this.left, this.down, Pass.YES);
            case RIGHT -> new Cell(Pass.YES, this.left, this.down, this.up);
            case LEFT -> new Cell(this.right, Pass.YES, this.down, this.up);
            default -> throw new IllegalArgumentException(NOT_IMPLEMENTED);
        };
    }
}
