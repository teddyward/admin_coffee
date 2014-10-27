package brewing;

import java.util.ResourceBundle;
import java.util.Scanner;

import coffeeComponents.Coffee;

/**
 * The "view." Deals with the "customer." bonus UX TODO: allow spaces after
 * commas
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class CoffeeHouse {

    private CoffeeFactory factory;

    private ResourceBundle resources;
    private static final String DEFAULT_SCRIPT_LOCATION = "resources.englishScript";

    public CoffeeHouse() {
        resources = ResourceBundle
                .getBundle(CoffeeHouse.DEFAULT_SCRIPT_LOCATION);
        factory = new CoffeeFactory();
    }

    public void takeOrder() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(resources.getString("welcome"));
        System.out.println(resources.getString("prompt"));
        System.out.println(resources.getString("instructions"));

        factory.printMenu();

        String order = scanner.nextLine();

        Coffee coffee = factory.makeCoffee(resources, order);

        System.out.println(String.format(resources.getString("offer"), 
                coffee.getDescription()));
        System.out.println(String.format(resources.getString("ingredients"),
                coffee.getIngredients()));
        System.out.println(String.format(resources.getString("charge"), 
                coffee.getCost()));

        scanner.close();
    }
}
