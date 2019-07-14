public class MoveValidator {
    public static boolean validate(Board board, int move) {
        Piece piece;
        try {
            piece = board.getField(move);
        } catch (InvalidFieldIndexException e) {
            return false;
        }

        if (piece != null) {
            return false;
        }

        return true;
    }
}
