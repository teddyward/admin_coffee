package decoratedCoffee;

import java.util.Calendar;
import java.util.ResourceBundle;

import brewing.CoffeeFactory;
import coffeeComponents.Coffee;

/**
 * A type of add-on for a coffee that is cheaper in one month of the year!
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class SeasonalDecoratedCoffee extends SimpleDecoratedCoffee {

    /**
     * months in java are 0-based, but we want users to type 1-based months into
     * the properties file
     */
    private static final int MONTH_BASE_CONVERSION = -1;
    private static final int SEASONAL_MONTH_SECTION = 4;
    private static final int OUT_OF_SEASON_COST_SECTION = 5;

    public SeasonalDecoratedCoffee(ResourceBundle resources,
            Coffee decoratedCoffee, String resourceListing) {
        super(resources, decoratedCoffee, resourceListing);

        int inSeasonMonth = Integer.parseInt(CoffeeFactory
                .getSectionFromResourceInfo(resourceListing,
                        SeasonalDecoratedCoffee.SEASONAL_MONTH_SECTION))
                + SeasonalDecoratedCoffee.MONTH_BASE_CONVERSION;
        double outOfSeasonCost = Double.parseDouble(CoffeeFactory
                .getSectionFromResourceInfo(resourceListing,
                        SeasonalDecoratedCoffee.OUT_OF_SEASON_COST_SECTION));

        if (Calendar.getInstance().get(Calendar.MONTH) != inSeasonMonth) {
            cost = outOfSeasonCost;
        }
    }

}