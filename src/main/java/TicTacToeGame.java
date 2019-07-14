import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private Board board = new Board(3, 3);
    private List<Player> players;
    private GameProgress gameProgress = new GameProgress(board);

    public void run() {
        TicTacToeMenu menu = new TicTacToeMenu();
        menu.printMenu();

        switch (menu.getAction()) {
            case TicTacToeMenu.EXIT:
                System.out.println("wychodze");
                break;
            case TicTacToeMenu.PLAY_WITH_COMPUTER:
                cleanBoard();
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

    private void cleanBoard() {
        this.board = new Board(3, 3);
    }

    private void start()
    {
        int moveCounter = 0;
        while (!gameProgress.endGame()) {
            int playerNumber = moveCounter % 2;
            Player player = this.players.get(playerNumber);
            System.out.println("Player " + (playerNumber + 1) + ":");

            this.board.print();
            int move = player.makeMove(board);
            if (!MoveValidator.validate(board, move)) {
                System.out.println("Ruch nieprawidłowy");
                continue;
            }

            this.board.setField(move, player.getPiece());

            gameProgress.setBoard(this.board);
            moveCounter++;
        }

        this.board.print();
        System.out.println("Koniec gry");
        for (Player player: players) {
            if (gameProgress.isPieceWon(player.getPiece())) {
                System.out.println("Wygrał gracz: " + player);
            }
        }
    }
}
