/* Project that simulates an automatic coffee machine that allows you to buy, serve the coffee, renew the supplies,
 take  money or check the remaining supplies.

Requirements:
The machine must work with 4 typical elements: coffee, milk, sugar and plastic cups.
The machine must offer you three types of coffee: espresso, cappuccino, and latte.
The machine must notify if the supplies are not sufficient for the preparation of coffee.
The machine must notify when taking the money.
The machine must allow for several consecutive actions without exiting.

STAGE 5
DaloxC
*/
package machine.stage5;

import java.util.*;

public class MasterCoffeeMachine {
    // Block to initialize variables and minimum input and output conditions.
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static Boolean exit = false;

    static Scanner scanner = new Scanner(System.in);
    // Block with the main menu of the machine.
    enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    static Status curStatus = Status.CHOOSING;

    public static void main(String[] args) {
        // Block that divides the different options to be executed.
        do {
            System.out.println(curStatus);
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    // Block that access the buy method.
                    curStatus = Status.BUYING;
                    System.out.println(curStatus);
                    buy();
                    break;
                case "fill":
                    // Block that access the fill method.
                    curStatus = Status.FILLING;
                    System.out.println(curStatus);
                    fill();
                    break;
                case "take":
                    // Block that access the take method.
                    curStatus = Status.TAKING;
                    System.out.println(curStatus);
                    take();
                    break;
                case "remaining":
                    // Block that access the remaining method.
                    curStatus = Status.REMAINING;
                    System.out.println(curStatus);
                    remaining();
                    break;
                case "exit":
                    // Block that access the exit method.
                    exit();
                    System.out.println(curStatus);
                    break;
            }
        } while (curStatus != Status.EXITING);
    }
    // Block to BUY
    static void buy() {
        // Block that request the type of coffee to buy.
        System.out.println();
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next();
        // Block with the logic of the 3 different types of coffee.
        switch (choice) {
            // Block 1 espresso.
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                    break;
                }
            }
            // Block 2 latte.
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    break;
                }
            }
            // Block 3 cappuccino.
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
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
        curStatus = Status.CHOOSING;
    }
    // Block to FILL
    static void fill() {
        /// Block with the add requests.
        System.out.println();
        System.out.print("Write how many ml of water do you want to add: ");
        int waterAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many ml of milk do you want to add: ");
        int milkAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        int beansAdd = scanner.nextInt();
        System.out.println();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        int cupsAdd = scanner.nextInt();
        System.out.println();
        // Block with the addition to the variable.
        water += waterAdd;
        milk += milkAdd;
        beans += beansAdd;
        cups += cupsAdd;

        curStatus = Status.CHOOSING;
    }
    // Block to TAKE
    static void take() {
        System.out.println("I gave you $" + money + "\n"); // Money delivery message
        money = 0;

        curStatus = Status.CHOOSING;
    }
    // Block to REMAINING
    static void remaining() {
        // Block that shows what the machine has.
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();

        curStatus = Status.CHOOSING;
    }
    // Block to EXIT
    static void exit() {
        curStatus = Status.EXITING;
    }
    // Block to validate the resources that the machine has.
    static boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (beans >= beansNeed) {
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

