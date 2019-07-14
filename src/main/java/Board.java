import java.util.Arrays;

public class Board {
    private Piece board[][];
    private int x;
    private int y;

    Board(int x, int y) {
        this.x = x;
        this.y = y;
        this.board = new Piece[x][y];
    }

    Board(Board board) {
        this.x = board.getX();
        this.y = board.getY();
        this.board = new Piece[x][y];
        for (int x = 0; x < board.getBoard().length; x++) {
            for (int y = 0; y < board.getBoard().length; y++) {
                this.board[x][y] = board.getBoard()[x][y];
            }
        }
    }

    public Piece getField(int index) throws InvalidFieldIndexException {
        int indexCounter = 0;

        for (int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++) {
                if (++indexCounter == index) {
                    return this.board[x][y];
                }
            }
        }

        throw new InvalidFieldIndexException();
    }

    public void setField(int index, Piece piece) {
        int indexCounter = 0;

        for (int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++) {
                if (++indexCounter == index) {
                    this.board[x][y] = piece;

                }
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void print() {
        int index = 0;

        for (int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++) {
                printPiece(this.board[x][y], ++index);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printPiece(Piece piece, int index) {
        System.out.print("[");
        if (piece == null) {
            System.out.print(index);
        } else {
            System.out.print(piece.getSymbol());
        }
        System.out.print("]");
    }
}
