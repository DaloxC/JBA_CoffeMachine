/* Project that simulates an automatic coffee machine that allows you to buy, serve the coffee, renew the supplies,
 take  money or check the remaining supplies.

Requirements:
The machine must work with 4 typical elements: coffee, milk, sugar and plastic cups.
The machine must offer you three types of coffee: espresso, cappuccino, and latte.
The machine must notify if the supplies are not sufficient for the preparation of coffe.
The machine must notify when taking the money.
The machine must allow for several consecutive actions without exiting.

STAGE 1
DaloxC
*/
package machine.stage1;

public class MasterCoffeeMachine {
    // Print Menu
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }
}
