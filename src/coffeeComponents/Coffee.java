package coffeeComponents;

/**
 * Adapted from example of the decorator pattern
 * http://en.wikipedia.org/wiki/Decorator_pattern#Second_example_.28coffee_making_scenario.29
 * @author Teddy Ward
 */
public interface Coffee {
	
	/**
	 * 
	 * @return
	 */
	public String getIngredients();
	
	/**
	 * Returns the cost of the coffee drink
	 */
	public double getCost();
	
	/**
	 * Gives a description of everything in the coffee drink
	 */
	public String getDescription();
}
