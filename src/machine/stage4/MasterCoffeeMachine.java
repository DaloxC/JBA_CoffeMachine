/* Project that simulates an automatic coffee machine that allows you to buy, serve the coffee, renew the supplies,
 take  money or check the remaining supplies.

Requirements:
The machine must work with 4 typical elements: coffee, milk, sugar and plastic cups.
The machine must offer you three types of coffee: espresso, cappuccino, and latte.
The machine must notify if the supplies are not sufficient for the preparation of coffee.
The machine must notify when taking the money.
The machine must allow for several consecutive actions without exiting.

STAGE 4
DaloxC
*/
package machine.stage4;

import java.util.*;

public class MasterCoffeeMachine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Block to initialize variables and show what the machine has.
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int nCups = 9;
        int money = 550;
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(nCups + " disposable cups");
        System.out.println("$" + money + " of money");

        //Block that requests the machine to perform action.
        System.out.println("\nWrite action (buy, fill, take)");
        String option = s.nextLine();

        //Block that divides the different options to be executed.
        switch (option) {
            // Block to BUY
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");

                //Block with the logic of the 3 different types of coffee.
                switch (s.nextInt()) {
                    //Block 1 espresso.
                    case 1:
                        System.out.println("The coffee machine has:");
                        System.out.println((water -= 250) + " ml of water");
                        System.out.println(milk + " ml of milk");
                        System.out.println((coffeeBeans -= 16) + " g of coffee beans");
                        System.out.println(--nCups + " disposable cups");
                        System.out.println("$" + (money += 4) + " of money");
                        break;
                    //Block 2 latte.
                    case 2:
                        System.out.println("The coffee machine has:");
                        System.out.println((water -= 350) + " ml of water");
                        System.out.println((milk -= 75) + " ml of milk");
                        System.out.println((coffeeBeans -= 20) + " g of coffee beans");
                        System.out.println(--nCups + " disposable cups");
                        System.out.println("$" + (money += 7) + " of money");
                        break;
                    //Block 3 cappuccino.
                    case 3:
                        System.out.println("The coffee machine has:");
                        System.out.println((water -= 200) + " ml of water");
                        System.out.println((milk -= 100) + " ml of milk");
                        System.out.println((coffeeBeans -= 12) + " g of coffee beans");
                        System.out.println(--nCups + " disposable cups");
                        System.out.println("$" + (money += 6) + " of money");
                        break;
                }
                break;
            // Block to FILL
            case "fill":
                // Block with addition request followed by the instantaneous addition to the variable.
                System.out.println("Write how many ml of water you want to add:");
                water += s.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                milk += s.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                coffeeBeans += s.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                nCups += s.nextInt();

                //Block that prints the result of the addition.
                System.out.println("\nThe coffee machine has:");
                System.out.println(water + " ml of water");
                System.out.println(milk + " ml of milk");
                System.out.println(coffeeBeans + " g of coffee beans");
                System.out.println(nCups + " disposable cups");
                System.out.println("$" + money + " of money");
                break;
            // Block to TAKE
            case "take":
                System.out.println("I gave you $" + money); // Money delivery message

                //Block that prints the result with the subtraction of the money that was awarded.
                System.out.println("\nThe coffee machine has:");
                System.out.println(water + " ml of water");
                System.out.println(milk + " ml of milk");
                System.out.println(coffeeBeans + " g of coffee beans");
                System.out.println(nCups + " disposable cups");
                System.out.println("$" + (money - money) + " of money");
                break;
        }
    }
}
