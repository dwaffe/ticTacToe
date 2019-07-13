import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeMenu extends Menu {
    public final static String PLAY_WITH_COMPUTER = "Graj z komputerem";
    public final static String EXIT = "Wyjdź";

    public TicTacToeMenu() {
        addElement(PLAY_WITH_COMPUTER);
        addElement(EXIT);
    }
}
