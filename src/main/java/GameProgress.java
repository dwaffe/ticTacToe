public class GameProgress {
    private Board board;

    public GameProgress(Board board) {
        this.board = board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isPieceWon(Piece piece) {
        int[][] winningCombinations = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9},
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9},
                {1, 5, 9},
                {3, 5 ,7}
        };

        for (int[] combination: winningCombinations) {
            try {
                if (board.getField(combination[2]).equals(piece)
                    && board.getField(combination[1]).equals(piece)
                    && board.getField(combination[0]).equals(piece)) {
                    return true;
                }
            } catch (InvalidFieldIndexException e) {
                continue;
            } catch (NullPointerException e) {
                continue;
            }

        }

        return false;
    }

    public boolean endGame() {
        if (isPieceWon(new XPiece()) || isPieceWon(new OPiece())) {
            return true;
        }

        int i = 0;
        while (true) {
            i++;
            try {
                if (board.getField(i) == null) {
                    return false;
                }
            } catch (InvalidFieldIndexException e) {
                break;
            }
        }

        return true;
    }
}
