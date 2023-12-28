import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Toy
 */
public class Toy implements i_EditToy {

    private int toyID;
    private String toysName;
    private int toysQuantity;
    private double toysWeight;

    public Toy(String toysName, int toysQuantity, int toyID, double toysWeight) {

        this.toysName = toysName;
        this.toysQuantity = toysQuantity;
        this.toyID = toyID;
        this.toysWeight = toysWeight;

    }

    public Toy(int toyID) {
        try (Scanner input = new Scanner(System.in)) {

            this.toyID = toyID;
            System.out.println("Enter toys name: ");
            this.toysName = input.nextLine();
            System.out.println("Enter toys quantity you'd like to add: ");
            this.toysQuantity = input.nextInt();
            System.out.println("Enter toys weight in double:\n(Example: 3,250 means 3 kg and 250 grams)");
            this.toysWeight = input.nextDouble();

        } catch (Exception e) {
            System.err.println("Uncorrect data entered. Please, redo.");

        }
    }

    public Toy(Scanner input) {

        try {

            System.out.println("\nEnter toys name:\n");

            this.toysName = input.next();

            System.out.println("\nEnter toys quantity you'd like to add: \n");
            this.toysQuantity = input.nextInt();
            System.out.println("\nEnter toys weight in double:\n(Example: 3,250 means 3 kg and 250 grams)\n");
            this.toysWeight = input.nextDouble();

        } catch (RuntimeException e) {
            System.err.println("Uncorrect data entered. Please, redo.");
            // new Toy(input);
        }
    }

    @Override
    public void editWeight(LinkedList<Toy> toysList, Scanner input) {
        try {
            System.out.println("Enter the toys name you would like to edit: ");
            String myAnswer = input.nextLine().toUpperCase();
            int counter = 0;
            for (int i = 0; i < toysList.size(); i++) {
                if (myAnswer.equals(toysList.get(i).getToysName().toUpperCase())) {
                    System.out.println("Entered Weight is: " + toysList.get(i).getToysWeight());
                    System.out.println("Enter new Weight:\nFormat: kg,ggg\n");
                    try {
                        toysList.get(i).setToysWeight(input.nextDouble());

                        break;
                    } catch (Exception e) {
                        System.err.println("Wrong data format of Weight.\n(Example: 3,250 means 3 kg and 250 grams)");
                        editWeight(toysList, input);
                    }

                } else {
                    counter++;
                }

            }
            if (counter == 0) {
                System.err.println("No such name found. Please, redo");
                editWeight(toysList, input);
            }

        } catch (RuntimeException e) {
            System.err.println("Wrong data format of Weight.\n(Example: 3.250 means 3 kg and 250 grams)");
            editWeight(toysList, input);
        }

    }

    @Override
    public void editQuantity(LinkedList<Toy> toysList, Scanner input) {
        try {
            System.out.println("Enter the toys name you would like to edit: ");
            String myAnswer = input.nextLine().toUpperCase();
            int counter = 0;
            for (int i = 0; i < toysList.size(); i++) {
                if (myAnswer.equals(toysList.get(i).getToysName().toUpperCase())) {
                    System.out.println("Entered Quantity is: " + toysList.get(i).getToysQuantity());
                    System.out.println("Enter new Quantity:");
                    try {
                        toysList.get(i).setToysQuantity(input.nextInt());

                        break;
                    } catch (Exception e) {
                        System.err.println("Wrong data format of Quantity (int).\n");
                        editQuantity(toysList, input);
                    }

                } else {
                    counter++;
                }

            }
            if (counter == 0) {
                System.err.println("No such name found. Please, redo");
                editQuantity(toysList, input);
            }

        } catch (RuntimeException e) {
            System.err.println("Wrong data format of Quantity.\n");
            editQuantity(toysList, input);
        }
    }

    @Override
    public void editName() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Change the Name: ");
            this.toysName = input.nextLine();

        } catch (Exception e) {
            System.err.println("Not correct data for Name Editing.\nPlease, just enter String:\n");
            editName();
        }
    }

    public String toyToString() {
        return String.format("ID: %d, Name: %s, Quantity: %d, Weight: %.3f\n", getToyID(), getToysName(),
                getToysQuantity(), getToysWeight());
    }

    public void getToy(PriorityQueue<Toy> mPriorityQueue) {
        System.out.println(mPriorityQueue.poll().toyToString());
    }

    //////
    public double getToysWeight() {
        return toysWeight;
    }

    public void setToysWeight(double toysWeight) {
        this.toysWeight = toysWeight;
    }

    public int getToyID() {
        return toyID;
    }

    public void setToyID(int toyID) {
        this.toyID = toyID;
    }

    public String getToysName() {
        return toysName;
    }

    public void setToysName(String toysName) {
        this.toysName = toysName;
    }

    public int getToysQuantity() {
        return toysQuantity;
    }

    public void setToysQuantity(int toysQuantity) {
        this.toysQuantity = toysQuantity;
    }

}