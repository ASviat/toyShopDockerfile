import java.util.LinkedList;
import java.util.Scanner;

/**
 * Storage
 */
public class Storage {

    LinkedList<Toy> toysList = new LinkedList<>();

    int toysQuantityInStorage;
    String pickedToyForGame;

    /**
     * Counts all toys in storage
     */
    public void allToysQuantity() {
        int quantity = 0;
        for (Toy toy : toysList) {
            quantity += toy.getToysQuantity();
        }
        this.toysQuantityInStorage = quantity;
    }

    /**
     * Shows all toys in storage
     */
    public void showStorage() {
        System.out.println("Goods in the storage:");
        for (Toy toy : toysList) {

            System.out.printf("ID: %d - Name: '%s' - Weight: '%.3f' - Quantity: %d\n", toy.getToyID(),
                    toy.getToysName(),
                    toy.getToysWeight(),
                    toy.getToysQuantity());
        }
        System.out.println();
    }

    /**
     * Asks to select a toy.
     * 
     * @param myList
     */
    public void pickToy(Scanner input) {
        try  {
            System.out.println("Which toy would u like to try to pick? ");
            System.out.println("Remember, higher the weight -- more risk -- better the price!");
            System.out.println("Write toy's name to pick: ");
            int counter = 0;
            String myAnswer = input.nextLine().toUpperCase();
            for (int i = 0; i < toysList.size(); i++) {
                if (toysList.get(i).getToysName().toUpperCase().equals(myAnswer.toUpperCase())) {

                    counter = 0;
                    //int quantity = toysList.get(i).getToysQuantity();
                    //toysList.get(i).setToysQuantity(quantity - 1);
                    if (toysList.get(i).getToysQuantity()-1 == 0) {
                        System.out.printf("Last toy '%s' picked\n", toysList.get(i).getToysName());
                        this.pickedToyForGame = myAnswer;
                        // toysList.remove(i);

                    } else {
                        System.out.printf("Toy '%s' picked.\n", toysList.get(i).getToysName());
                        this.pickedToyForGame = myAnswer;
                    }

                }
                if (!toysList.get(i).getToysName().toUpperCase().equals(myAnswer.toUpperCase())) {
                    counter++;

                }
                if (counter == toysList.size()) {
                    System.err.println("Thx for money, bye.\n(Insert additional coin to start again)\n");
                }

            }

        } catch (RuntimeException e) {
            System.err.println("Pick the toy that exists!");

        }
    }

    /**
     * Add toy to storage.
     */
    public void addToStorage(Scanner input)  {
        
            toysList.add(new Toy(input));
       
        
    }
}