import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Random;

/**
 * GameMachine
 */
public class GameMachine {

    Queue<Toy> myDeliveryQueue = new LinkedList<Toy>();

    // PriorityQueue<Toy> mPriorityQueue = new PriorityQueue<>(
    // (o1, o2) -> Double.compare(o1.getToysWeight(), o2.getToysWeight()));

    /**
     * Rolling a chance to pick selected toy in a game a give toy if its a win.
     * 
     * @throws InterruptedException
     */
    public void rollThePickedToy(String pickedToy, LinkedList<Toy> myList) {
        try {
            Random randomRoll = new Random();
            double pickedToysWeight = 0;
            for (Toy toy : myList) {
                if (pickedToy.equals(toy.getToysName())) {
                    pickedToysWeight = toy.getToysWeight();
                    break;
                }
            }
            double k = pickedToysWeight / 5; // We take 5 kg for max weight.
            double playersRoll = randomRoll.nextDouble(100) * (1 - k);
            System.out.print("You roll .");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(700);
            System.out.print(".\n");
            System.out.printf("%.2f", playersRoll);

            System.out.print("\nKasino rolles .");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(700);
            System.out.print(".\n");
            Thread.sleep(700);
            // System.out.println("Pray to the Lord additional 2 seconds!");
            // Thread.sleep(2000);
            double kasinoRoll = randomRoll.nextDouble(100);
            System.out.printf("%.2f", kasinoRoll);

            if (playersRoll > kasinoRoll) {
                System.out.println("\nCongratulation! You won!\n");
                for (int i = 0; i < myList.size(); i++) {
                    if (pickedToy.toUpperCase().equals(myList.get(i).getToysName().toUpperCase())) {
                        int quantity = myList.get(i).getToysQuantity();
                        myList.get(i).setToysQuantity(quantity - 1);

                        myDeliveryQueue.add(myList.get(i));
                        if (myList.get(i).getToysQuantity() == 0) {
                            myList.remove(i);
                        }
                        System.out.println("Had been writen to Delivery Queue.\n");
                        
                        break;
                    }
                }
            } else {
                System.out.println("\nShame on you, looser!\n");
            }

        } catch (InterruptedException e) {
            System.err.println("\nDon't interrupt the waiting of rolling! Be patient!");
            rollThePickedToy(pickedToy, myList);
        }

    }

    public void takeAwayTheWonToy() {
        if (!myDeliveryQueue.isEmpty()) {
            System.out.println("Toy was delivered.");
            System.out.println("(Name: " + myDeliveryQueue.peek().getToysName() + " | ID: "
                    + myDeliveryQueue.peek().getToyID() + ")");
            try (FileWriter fw = new FileWriter("D:\\GB\\Algoritms and structure of data\\Practice\\ToyShop\\WinnersQueue.txt", true)) {
                fw.write("Toy: " + myDeliveryQueue.element().getToysName() + " | ");
                fw.write("Weight: " + myDeliveryQueue.element().getToysWeight() + " | " + new Date() + "\n");
                fw.close();
                myDeliveryQueue.poll();

            } catch (IOException e) {
                System.err.println("Connection was closed during writing.");
            }

        } else {
            System.err.println("No toys in the queue for winners");
        }
    }

    public void showToysQueueForWinners() {
        for (int i = 0; i < this.myDeliveryQueue.size(); i++) {
            System.out.println("Toy: " + myDeliveryQueue.element().getToysName());
        }
    }

}