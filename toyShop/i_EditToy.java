import java.util.LinkedList;
import java.util.Scanner;

/**
 * i_EditToy
 */
public interface i_EditToy {

    public void editWeight(LinkedList<Toy> toysList,Scanner input);

    public void editQuantity(LinkedList<Toy> toysList, Scanner input);

    public void editName();
    // public void pickToy(PriorityQueue<Toy> myQueue);
}