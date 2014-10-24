package coffeeComponents;

import java.util.ResourceBundle;

/**
 * Coffee with milk in it.  Ew.
 * @author Teddy Ward
 */
public class CoffeeWithMilk extends DecoratedCoffee {

	public CoffeeWithMilk(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
	}
	
	/**
	 * At the subclass level, add to the cost
	 */
    public double getCost() {
        return super.getCost() + .5;
    }
	
    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("milk");
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("milkDescription");
    }

}
