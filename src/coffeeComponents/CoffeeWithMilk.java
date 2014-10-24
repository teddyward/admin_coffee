package coffeeComponents;

import java.util.ResourceBundle;

public class CoffeeWithMilk extends DecoratedCoffee {

	public CoffeeWithMilk(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
	}
	
    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("milk");
    }

    public double getCost() {
        return decoratedCoffee.getCost() + .5;
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("milkDescription");
    }

}
