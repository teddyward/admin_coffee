package coffeeComponents;

import java.util.ResourceBundle;

/**
 * Coffee with sprinkles on top!!!~!!!
 * @author Teddy Ward
 */
public class CoffeeWithSprinkles extends DecoratedCoffee {
	
	public CoffeeWithSprinkles(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
	}

    public double getCost() {
        return super.getCost() + .2;
    }

    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("sprinkles");
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("sprinklesDescription");
    }
}
