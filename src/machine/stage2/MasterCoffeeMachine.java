/* Project that simulates an automatic coffee machine that allows you to buy, serve the coffee, renew the supplies,
 take  money or check the remaining supplies.

Requirements:
The machine must work with 4 typical elements: coffee, milk, sugar and plastic cups.
The machine must offer you three types of coffee: espresso, cappuccino, and latte.
The machine must notify if the supplies are not sufficient for the preparation of coffee.
The machine must notify when taking the money.
The machine must allow for several consecutive actions without exiting.

STAGE 2
DaloxC
*/
package machine.stage2;

import java.util.Scanner;

public class MasterCoffeeMachine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Print Menu
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
        System.out.println("Write how many cups of coffee you will need: ");
        int nCups = s.nextInt();
        // Print & calculate the amount of ingredients needed to make a certain amount of coffee.
        System.out.println("For " + nCups + " cups of coffee you will need:");
        System.out.println((200 * nCups) + " ml of water");
        System.out.println((50 * nCups) + " ml of milk");
        System.out.println((15 * nCups) + " g of coffee beans");
    }
}
