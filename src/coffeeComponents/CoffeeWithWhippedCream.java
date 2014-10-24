package coffeeComponents;

import java.util.ResourceBundle;

/**
 * Coffee with whipped cream.  Pure decadence.
 */
public class CoffeeWithWhippedCream extends DecoratedCoffee {

	public CoffeeWithWhippedCream(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
	}

    public double getCost() {
        return super.getCost() + 1;
    }
	
    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("whippedCream");
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("whippedCreamDescription");
    }
}
