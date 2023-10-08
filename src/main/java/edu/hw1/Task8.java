package edu.hw1;

public class Task8 {
    private final static int BOARD_SIZE = 8;
    private final static String BOARD_SIZE_ERROR_MESSAGE = "Размер доски должен быть 8x8";

    public boolean knightBoardCapture(int[][] board) {
        validateBoard(board);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                /*
                 * Имеет смысл проверять на захват только в нижнем направлении.
                 * Захват наверх был бы рассмотрен на предыдущих
                 * итерациях.
                 **/
                if (board[i][j] == 1 && mayCaptureDown(i, j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean mayCaptureDown(int i, int j, int[][] board) {
        int[][] moves = {
            {i + 2, j - 1},
            {i + 2, j + 1},
            {i + 1, j - 2},
            {i + 1, j + 2}
        };

        for (var move : moves) {
            if (move[0] < 0 || move[0] >= BOARD_SIZE || move[1] < 0 || move[1] >= BOARD_SIZE) {
                continue;
            }

            if (board[move[0]][move[1]] == 1) {
                return true;
            }
        }

        return false;
    }

    private void validateBoard(int[][] board) {
        if (board.length != BOARD_SIZE) {
            throw new IllegalArgumentException(BOARD_SIZE_ERROR_MESSAGE);
        }

        for (var row : board) {
            if (row.length != BOARD_SIZE) {
                throw new IllegalArgumentException(BOARD_SIZE_ERROR_MESSAGE);
            }
        }
    }
}
