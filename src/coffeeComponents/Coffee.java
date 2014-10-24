package coffeeComponents;

/**
 * All coffee drinks (I guess this could include lattes, etc. -- bad naming)
 * and decorated coffees must extend this class
 * 
 * Adapted from example #2 of the decorator pattern
 * http://en.wikipedia.org/wiki/Decorator_pattern#Second_example_.28coffee_making_scenario.29
 * http://www.oodesign.com/decorator-pattern.html
 * 
 * @author Teddy Ward
 */
public interface Coffee {
	
	/**
	 * Returns a string that lists out all the ingredients in the coffee drink
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
