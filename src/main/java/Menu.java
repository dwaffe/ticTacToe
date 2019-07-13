import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> menuElements = new ArrayList<String>();

    public void printMenu() {
        int i = 1;
        for (String element : menuElements) {
            System.out.println(i + " " + element);
            i++;
        }
    }

    protected int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    protected void addElement(String element) {
        this.menuElements.add(element);
    }

    public String getAction() {
        return this.menuElements.get(getMenuChoice() - 1);
    }
}
