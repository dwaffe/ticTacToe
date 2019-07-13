public abstract class Player {
    private Piece piece;

    public Player(Piece piece) {
        this.piece = piece;
    }

    public abstract int makeMove();

    public Piece getPiece() {
        return piece;
    }
}
