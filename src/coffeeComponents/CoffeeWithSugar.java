package coffeeComponents;

import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Coffee with sugar. Sometimes out of season.
 * Otherwise, free!
 * @author Teddy Ward
 */
public class CoffeeWithSugar extends DecoratedCoffee {
	
	public static final int DECEMBER = 11;
	private boolean inSeason;

	public CoffeeWithSugar(Coffee decoratedCoffee, ResourceBundle resources) {
		super(decoratedCoffee, resources);
		// sugar is more expensive in December
		inSeason = !(Calendar.getInstance().get(Calendar.MONTH) == 11);
	}

    public double getCost() {
    	if(inSeason) {
            return super.getCost();
    	}
    	return super.getCost() + .2;
    }
	
    public String getIngredients() {
    	return super.getIngredients() + resources.getString("separator") + resources.getString("sugar");
    }
    
    public String getDescription() {
    	return super.getDescription() + resources.getString("separator") + resources.getString("sugarDescription");
    }

}
