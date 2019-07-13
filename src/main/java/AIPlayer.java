import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(Piece piece) {
        super(piece);
    }

    private Random random = new Random();

    @Override
    public int makeMove() {
        return random.nextInt(9) + 1;
    }
}
