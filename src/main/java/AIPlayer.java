import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(Piece piece) {
        super(piece);
    }

    private Random random = new Random();

    @Override
    public int makeMove(Board board) {
        for (int i = 1; i <= 9; i++) {
            Board tempBoard = new Board(board);
            tempBoard.setField(i, getPiece());
            if ((new GameProgress(tempBoard)).isPieceWon(getPiece())) {
                return i;
            }
        }

        return random.nextInt(9) + 1;
    }


}
