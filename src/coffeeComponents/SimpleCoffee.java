package coffeeComponents;

import java.util.ResourceBundle;

/**
 * A simple implementation of the coffee interface. Represents a basic cup of
 * coffee.
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class SimpleCoffee implements Coffee {

    private ResourceBundle resources;

    public SimpleCoffee(ResourceBundle resources) {
        this.resources = resources;
    }

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getDescription() {
        return resources.getString("coffeeDescription");
    }

    @Override
    public String getIngredients() {
        return resources.getString("coffee");
    }
}
