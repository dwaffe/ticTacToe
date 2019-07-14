import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameProgressTest {
    private Board board;
    private Piece Xpiece = new XPiece();
    private Piece Opiece = new OPiece();
    private GameProgress gameProgress;

    @BeforeEach
    void setUp() {
        board = new Board(3, 3);
        gameProgress = new GameProgress(board);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testWinningCombination() {
        int[][] winningCombination = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9},
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9},
                {1, 5, 9},
                {3, 5 ,7}
        };

        for (int[] oneCombination: winningCombination) {
            Board newBoard = new Board(3, 3);
            for (int move: oneCombination) {
                newBoard.setField(move, Xpiece);
            }
            gameProgress.setBoard(newBoard);
            assertTrue(gameProgress.isPieceWon(new XPiece()));
        }
    }

    @Test
    void testNotWinning() {
        assertFalse(gameProgress.isPieceWon(Xpiece));
        assertFalse(gameProgress.isPieceWon(Opiece));
        board.setField(1, Xpiece);
        board.setField(5, Opiece);
        board.setField(9, Xpiece);
        gameProgress.setBoard(board);
        assertFalse(gameProgress.isPieceWon(Xpiece));
        assertFalse(gameProgress.isPieceWon(Opiece));
    }

    @Test
    void testGameInProgress() {
        assertFalse(gameProgress.endGame());
        board.setField(3, Xpiece);
        board.setField(2, Opiece);
        board.setField(7, Xpiece);
        assertFalse(gameProgress.endGame());
    }

    @Test
    void testDrawEndGame() {
        board.setField(1, Xpiece);
        board.setField(2, Opiece);
        board.setField(3, Xpiece);
        board.setField(4, Opiece);
        board.setField(5, Xpiece);
        board.setField(6, Opiece);
        board.setField(7, Opiece);
        board.setField(8, Xpiece);
        board.setField(9, Xpiece);

        assertTrue(gameProgress.endGame());
    }

    @Test
    void testWinEndGame() {
        board.setField(7, Xpiece);
        board.setField(8, Xpiece);
        board.setField(9, Xpiece);
        gameProgress.setBoard(board);
        assertTrue(gameProgress.endGame());
    }






}
