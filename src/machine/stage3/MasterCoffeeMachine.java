/* Project that simulates an automatic coffee machine that allows you to buy, serve the coffee, renew the supplies,
 take  money or check the remaining supplies.

Requirements:
The machine must work with 4 typical elements: coffee, milk, sugar and plastic cups.
The machine must offer you three types of coffee: espresso, cappuccino, and latte.
The machine must notify if the supplies are not sufficient for the preparation of coffee.
The machine must notify when taking the money.
The machine must allow for several consecutive actions without exiting.

STAGE 3
DaloxC
*/

package machine.stage3;

import java.util.Scanner;

public class MasterCoffeeMachine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Block Print Menu
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
        //Block to read the amount of ingredients
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = s.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = s.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans = s.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int nCups2 = s.nextInt();
        int nCupsAvailable = Math.min(water / 200, Math.min(milk / 50, coffeeBeans / 15));
        int nCupsAvailable2 = nCupsAvailable - nCups2;

        //Block with the logic that will say whether you can make the amount of coffee.
        if (nCups2 == nCupsAvailable) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (nCups2 < nCupsAvailable) {
            System.out.println("Yes, I can make that amount of coffee (and even " + nCupsAvailable2 + " more than that)");
        } else if (nCups2 > nCupsAvailable) {
            System.out.println("No, I can make only " + nCupsAvailable + " cup(s) of coffee");
        }
    }
}

