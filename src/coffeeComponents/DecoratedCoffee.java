package coffeeComponents;

import java.util.ResourceBundle;

/**
 * Super class for all decorated coffees (eg: with sprinkles, with milk...)
 * @author Teddy Ward
 */
public abstract class DecoratedCoffee implements Coffee {

	private final Coffee decoratedCoffee;
	
	protected ResourceBundle resources;
	
    public DecoratedCoffee (Coffee decoratedCoffee, ResourceBundle resources) {
        this.decoratedCoffee = decoratedCoffee;
        this.resources = resources;
    }
 
    /**
     * At the superclass level, just return the cost of the coffee we're decorating
     */
    public double getCost() {
        return decoratedCoffee.getCost();
    }
 
    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
    
    public String getDescription() {
    	return decoratedCoffee.getDescription();
    }
}
