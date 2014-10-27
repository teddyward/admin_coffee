package decoratedCoffee;

import java.util.ResourceBundle;

import brewing.CoffeeFactory;
import coffeeComponents.Coffee;

/**
 * Super class for all decorated coffees (eg: coffee with milk)
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class SimpleDecoratedCoffee implements Coffee {

    protected final Coffee decoratedCoffee;
    protected double cost;
    protected String name;
    protected String description;

    protected ResourceBundle resources;

    private static final int NAME_SECTION = 0;
    private static final int COST_SECTION = 2;
    private static final int DESCRIPTION_SECTION = 3;

    public SimpleDecoratedCoffee(ResourceBundle resources,
            Coffee decoratedCoffee, String resourceListing) {
        this.decoratedCoffee = decoratedCoffee;
        this.resources = resources;
        name = CoffeeFactory.getSectionFromResourceInfo(resourceListing,
                SimpleDecoratedCoffee.NAME_SECTION);
        cost = Double.parseDouble(CoffeeFactory.getSectionFromResourceInfo(
                resourceListing, SimpleDecoratedCoffee.COST_SECTION));
        description = CoffeeFactory.getSectionFromResourceInfo(resourceListing,
                SimpleDecoratedCoffee.DESCRIPTION_SECTION);
    }

    /**
     * Return the current total cost of the coffee we're decorating + this
     * ingredient's cost
     *
     * All these methods use the decorator pattern to append dynamic
     * functionality/data to the superclass' results at run time.
     */
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + cost;
    }

    /**
     * Return the description of everything in the coffee we're decorating +
     * this ingredient's description
     */
    @Override
    public String getDescription() {
        return append(decoratedCoffee.getDescription(), description);
    }

    /**
     * Return the list of ingredients in the coffee we're decorating + this
     * ingredient
     */
    @Override
    public String getIngredients() {
        return append(decoratedCoffee.getIngredients(), name);
    }

    /**
     * Adds a new bit of information to the decorated coffee's results
     */
    private String append(String original, String toAdd) {
        return String.format(original + "%s%s",
                resources.getString("IOSeparator"), toAdd);
    }
}
