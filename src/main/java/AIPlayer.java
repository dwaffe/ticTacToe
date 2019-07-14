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

            if (!MoveValidator.validate(tempBoard, i)) {
                continue;
            }
            if ((new GameProgress(tempBoard)).isPieceWon(getPiece())) {
                return i;
            }
        }
        Piece opponent;

        if (getPiece().getSymbol() == 'X') {
            opponent = new OPiece();
        } else {
            opponent = new XPiece();
        }

        for (int i = 1; i <= 9; i++) {
            Board tempBoard = new Board(board);

            if (!MoveValidator.validate(tempBoard, i)) {
                continue;
            }

            tempBoard.setField(i, opponent);
            if ((new GameProgress(tempBoard)).isPieceWon(opponent)) {
                return i;
            }
        }

        return random.nextInt(9) + 1;
    }


}
