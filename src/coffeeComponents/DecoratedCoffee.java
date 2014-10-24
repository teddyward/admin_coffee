package coffeeComponents;

import java.util.ResourceBundle;

public abstract class DecoratedCoffee implements Coffee {

	public final Coffee decoratedCoffee;
	
	protected ResourceBundle resources;
	
    public DecoratedCoffee (Coffee decoratedCoffee, ResourceBundle resources) {
        this.decoratedCoffee = decoratedCoffee;
        this.resources = resources;
    }
 
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
