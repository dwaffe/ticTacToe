import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
