/* Project that simulates an automatic coffee machine that allows you to buy, serve the coffee, renew the supplies,
 take  money or check the remaining supplies.

Requirements:
The machine must work with 4 typical elements: coffee, milk, sugar and plastic cups.
The machine must offer you three types of coffee: espresso, cappuccino, and latte.
The machine must notify if the supplies are not sufficient for the preparation of coffe.
The machine must notify when taking the money.
The machine must allow for several consecutive actions without exiting.

STAGE 6
DaloxC
*/
package machine.stage6;

import java.util.*;

public class MasterCoffeeMachine {

    // Block to initialize variables and minimum input and output conditions.
    static int water = 400, milk = 540, coffeeBeans = 120, nCups = 9, money = 550;

    static Boolean exit = false;

    static Scanner s = new Scanner(System.in);

    // Block with the main menu of the machine.
    enum Status {
        CHOOSE, BUY, FILL, TAKE, REMAINING, EXIT
    }

    static Status curStatus = Status.CHOOSE;

    public static void main(String[] args) {
        // Block that divides the different options to be executed.
        do {
            System.out.println(curStatus);
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = s.next();
            switch (action) {
                // Block that access the buy method.
                case "buy":
                    curStatus = Status.BUY;
                    System.out.println("\n" + curStatus);
                    buy();
                    break;
                // Block that access the fill method.
                case "fill":
                    curStatus = Status.FILL;
                    System.out.println("\n" + curStatus);
                    fill();
                    break;
                // Block that access the take method.
                case "take":
                    curStatus = Status.TAKE;
                    System.out.println("\n" + curStatus);
                    take();
                    break;
                // Block that access the remaining method.
                case "remaining":
                    curStatus = Status.REMAINING;
                    System.out.println("\n" + curStatus);
                    remaining();
                    break;
                // Block that access the exit method.
                case "exit":
                    exit();
                    System.out.println("\n" + curStatus);
                    break;
            }
        } while (curStatus != Status.EXIT);
    }
    // Block to BUY
    static void buy() {
        // Block that request the type of coffee to buy.
        System.out.print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = s.next();
        // Block with the logic of the 3 different types of coffee.
        switch (choice) {
            // Block 1 espresso.
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    nCups--;
                    money += 4;
                    break;
                }
            }
            // Block 2 latte.
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    nCups--;
                    money += 7;
                    break;
                }
            }
            // Block 3 cappuccino.
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    nCups--;
                    money += 6;
                    break;
                }
            }
            case "back": {
                break;
            }
            default: {
                break;
            }
        }
        curStatus = Status.CHOOSE;
    }
    // Block to FILL
    static void fill() {
        // Block with the add requests.

        System.out.print("\nWrite how many ml of water do you want to add: ");
        int waterAdd = s.nextInt();

        System.out.print("\nWrite how many ml of milk do you want to add: ");
        int milkAdd = s.nextInt();

        System.out.print("\nWrite how many grams of coffee beans do you want to add: ");
        int beansAdd = s.nextInt();

        System.out.print("\nWrite how many disposable cups of coffee do you want to add: \n");
        int cupsAdd = s.nextInt();

        // Block with the addition to the variable.
        water += waterAdd;
        milk += milkAdd;
        coffeeBeans += beansAdd;
        nCups += cupsAdd;

        curStatus = Status.CHOOSE;
    }
    // Block to TAKE
    static void take() {

        System.out.println("\nI gave you $" + money + "\n"); // Money delivery message
        money = 0;

        curStatus = Status.CHOOSE;
    }
    // Block to REMAINING
    static void remaining() {
        // Block that shows what the machine has.
        System.out.printf(
                "\nThe coffee machine has:\n" +
                        "%d ml of water\n" +
                        "%d ml of milk\n" +
                        "%d g of coffee beans\n" +
                        "%d disposable cups\n" +
                        "$%d of money\n",
                water, milk, coffeeBeans, nCups, money
        );
        System.out.println();
        curStatus = Status.CHOOSE;
    }
    // Block to EXIT
    static void exit() {

        curStatus = Status.EXIT;
    }
    // Block to validate the resources that the machine has.
    static boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (coffeeBeans >= beansNeed) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }
}