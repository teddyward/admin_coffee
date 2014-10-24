package coffeeComponents;

import java.util.ResourceBundle;

public class CoffeeWithWhippedCream extends DecoratedCoffee {

	public CoffeeWithWhippedCream(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
	}
	
    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("whippedCream");
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 1;
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("whippedCreamDescription");
    }
}
