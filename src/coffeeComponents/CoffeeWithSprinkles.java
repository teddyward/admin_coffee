package coffeeComponents;

import java.util.ResourceBundle;

public class CoffeeWithSprinkles extends DecoratedCoffee {
	
	public CoffeeWithSprinkles(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
	}

    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("sprinkles");
    }

    public double getCost() {
        return decoratedCoffee.getCost() + .2;
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("sprinklesDescription");
    }
}
