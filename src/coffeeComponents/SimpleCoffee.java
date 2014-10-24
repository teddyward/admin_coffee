package coffeeComponents;

import java.util.ResourceBundle;

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
	public String getIngredients() {
		return resources.getString("coffee");
	}

	@Override
	public String getDescription() {
		return resources.getString("coffeeDescription");
	}
}
