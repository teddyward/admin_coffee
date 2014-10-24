package brewing;

import java.util.ResourceBundle;

import coffeeComponents.Coffee;
import coffeeComponents.CoffeeWithMilk;
import coffeeComponents.CoffeeWithSprinkles;
import coffeeComponents.CoffeeWithSugar;
import coffeeComponents.CoffeeWithWhippedCream;

/**
 * Factory for adding ingredients to a coffee.
 * Currently uses if statements to instantiate ingredients,
 * TODO: refactor to create ingredients using reflection.
 * @author Teddy Ward
 */
public class CoffeeFactory {
	
	private ResourceBundle resources;

	public CoffeeFactory(ResourceBundle resources) {
		this.resources = resources;
	}
	
	public Coffee makeCoffeeDecorator(Coffee decoratedCoffee, String decorationName) {
		if(decorationName.toLowerCase().equals(resources.getString("milk"))) {
			return new CoffeeWithMilk(decoratedCoffee, resources);
		}
		else if(decorationName.toLowerCase().equals(resources.getString("sprinkles"))) {
			return new CoffeeWithSprinkles(decoratedCoffee, resources);
		}
		else if(decorationName.toLowerCase().equals(resources.getString("sugar"))) {
			return new CoffeeWithSugar(decoratedCoffee, resources);
		}
		else if(decorationName.toLowerCase().equals(resources.getString("whippedCream"))) {
			return new CoffeeWithWhippedCream(decoratedCoffee, resources);
		}
		return decoratedCoffee;
	}
}
