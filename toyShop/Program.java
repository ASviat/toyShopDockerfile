import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) {

        int id = 1; // Counts addings and gives unique ID
        Scanner input = new Scanner(System.in);
        Storage storage = new Storage();
        storage.toysList.add(new Toy("Cat", 3, id++, 1.25));
        storage.toysList.add(new Toy("Dog", 1, id++, 4.0));
        storage.toysList.add(new Toy("Bug", 5, id++, 0.15));
        storage.toysList.add(new Toy("Fish", 2, id++, 0.25));
        GameMachine game = new GameMachine();
        mainMenu(id, storage, game, input);
        input.close();
    }

    public static void mainMenu(int id, Storage storage, GameMachine game, Scanner input) { // развести потоки сканнера

        System.out.println(
                "Select the process:\nPress 1 to show storage.\nPress 2 to add to storage.\nPress 3 to play the game.\nPress 4 to deliver the toy won\nPress 5 to edit the toy\nPress q to exit.");
        System.out.println();
        try {
            String myAnswer = input.nextLine();
            if (myAnswer.equals("1")) {

                storage.showStorage();
                System.out.println("Press 1 to count all the toys.\nPress 2 to return to main menu.\n");
                myAnswer = input.nextLine();
                if (myAnswer.equals("1")) {
                    storage.allToysQuantity();
                    System.out.println();
                    System.out.println("Total quantity of toys in the storage: " + storage.toysQuantityInStorage);
                    System.out.println();
                    mainMenu(id, storage, game, input);
                }

                else if (!myAnswer.equals("1")) {
                    System.err.println("Back to Main Menu.");
                    mainMenu(id, storage, game, input);
                }

            }
            else if (myAnswer.equals("2")) {

                storage.addToStorage(input);
                storage.toysList.getLast().setToyID(id++);
                System.out.println("Toy added.");

                mainMenu(id, storage, game, input);

            }
            else if (myAnswer.equals("3")) {
                System.out.println("The game begins!");
                storage.pickToy(input);
                game.rollThePickedToy(storage.pickedToyForGame, storage.toysList);
                // game.showToysQueueForWinners();
                mainMenu(id, storage, game, input);
            }
            else if (myAnswer.equals("4")) {
                game.takeAwayTheWonToy();

                mainMenu(id, storage, game, input);
            }
            else if (myAnswer.equals("5")) {
                System.out.println(
                        "What parameter would you like to edit?\nPress 1 to edit Name\nPress 2 to edit Weight\nPress 3 to edit Quantity\nPress q to exit to Main Menu\n");
                myAnswer = input.nextLine();
                if (myAnswer.equals("1")) {

                }
                 if (myAnswer.equals("2")) {
                    storage.showStorage();
                    storage.toysList.get(0).editWeight(storage.toysList, input);
                    mainMenu(id, storage, game, input);
                }
                else if (myAnswer.equals("3")) {
                    storage.showStorage();
                    storage.toysList.getLast().editQuantity(storage.toysList, input);
                    mainMenu(id, storage, game, input);
                }
                else if (myAnswer.toLowerCase().equals("q")) {
                    mainMenu(id, storage, game, input);

                } else {
                    throw new NoSuchElementException();
                }

                mainMenu(id, storage, game, input);
            }
            if (myAnswer.toLowerCase().equals("q")) {
                System.out.println("\nBye");
                

            }
            else {
            throw new NoSuchElementException();
            }


            // mainMenu(id, storage, game, input);
        } catch (NoSuchElementException|IllegalStateException e) {
            mainMenu(id, storage, game, input);
        }

    }

}