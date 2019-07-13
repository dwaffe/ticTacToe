import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private Board board;
    private List<Player> players;

    public void run() {
        TicTacToeMenu menu = new TicTacToeMenu();
        menu.printMenu();

        switch (menu.getAction()) {
            case TicTacToeMenu.EXIT:
                System.out.println("wychodze");
                break;
            case TicTacToeMenu.PLAY_WITH_COMPUTER:
                prepareBoard();
                preparePlayers(
                        new HumanPlayer(new XPiece()),
                        new AIPlayer(new OPiece())
                );
                start();
                break;
        }
    }

    private void preparePlayers(Player A, Player B) {
        this.players = new ArrayList<Player>();
        players.add(A);
        players.add(B);
    }

    private void prepareBoard() {
        this.board = new Board(3, 3);
    }

    private void start()
    {
        int moveCounter = 0;
        // todo: warunek zakończenia
        while (true) {
            this.board.print();
            Player player = this.players.get(moveCounter % 2);
            int move = player.makeMove();
            this.board.setField(move, player.getPiece());

            moveCounter++;
        }
    }
}
