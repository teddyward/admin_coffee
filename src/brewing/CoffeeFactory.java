package brewing;

import java.util.ResourceBundle;

import coffeeComponents.Coffee;
import coffeeComponents.SimpleCoffee;
import decoratedCoffee.RestrictedDecoratedCoffee;
import decoratedCoffee.SeasonalDecoratedCoffee;
import decoratedCoffee.SimpleDecoratedCoffee;

/**
 * Factory for adding ingredients to a coffee. Currently uses if statements to
 * instantiate ingredients,
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class CoffeeFactory {

    private static final ResourceBundle RESOURCES = ResourceBundle
            .getBundle("resources.englishDecorators");

    private static final int NAME_SECTION = 0;
    private static final int CLASS_PATH_SECTION = 1;

    /**
     * Get the package.className from a decorator's data (pulled from the
     * decorator resource file) Intentionally not used for now -- will need to
     * be used to implement reflection
     *
     * @param resourceInfo
     *            the decorator's data
     */
    private static String getResourceClass(String resourceInfo) {
        return CoffeeFactory.getSectionFromResourceInfo(resourceInfo,
                CoffeeFactory.CLASS_PATH_SECTION);
    }

    private static String getResourceName(String resourceInfo) {
        return CoffeeFactory.getSectionFromResourceInfo(resourceInfo,
                CoffeeFactory.NAME_SECTION);
    }

    /**
     * Gets the value of a certain section of the resource|info
     *
     * @param resourceInfo
     *            the string describing this object from the resource file
     * @param section
     *            the section number to get the value of (0 based!)
     * @return
     */
    public static String getSectionFromResourceInfo(String resourceInfo,
            int section) {
        String[] resourceInfoArray = resourceInfo.split(CoffeeFactory.RESOURCES
                .getString("resourceSeparator"));
        if (resourceInfoArray.length > section) {
            return resourceInfoArray[section];
        }
        return "";
    }

    /**
     * Make a cup of coffee based on the given order
     *
     * @param promptResources
     *            resource bundle for the "lines" that the "barista" says
     * @param order
     *            the order that the user typed in
     * @return A fully constructed coffee with all the order's decorators
     */
    public Coffee makeCoffee(ResourceBundle promptResources, String order) {
        Coffee coffee = new SimpleCoffee(promptResources);
        for (String ingredient : order.split(promptResources.getString("IOSeparator"))) {
            coffee = makeCoffeeDecorator(coffee, promptResources, ingredient);
        }
        return coffee;
    }

    /**
     * TODO: change to initialize using reflection
     *
     * @param decoratedCoffee
     *            coffee that the decorator is decorating
     * @param promptResources
     *            resource bundle for the "lines" that the "barista" says
     * @param ingredientName
     *            name of the decoration as input by the user
     * @return A coffee decorator
     */
    public Coffee makeCoffeeDecorator(Coffee decoratedCoffee,
            ResourceBundle promptResources, String ingredientName) {
        String milkResource = CoffeeFactory.RESOURCES.getString("milk");
        String sugarResource = CoffeeFactory.RESOURCES.getString("sugar");
        String brownieResource = CoffeeFactory.RESOURCES
                .getString("brownieBrittle");
        String pumpkinResource = CoffeeFactory.RESOURCES
                .getString("pumpkinSpice");
        String eggnogResource = CoffeeFactory.RESOURCES.getString("eggnog");
        String chocolateMilkResource = CoffeeFactory.RESOURCES
                .getString("chocolateMilk");
        String espressoResource = CoffeeFactory.RESOURCES.getString("espresso");

        if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(milkResource))) {
            return new SimpleDecoratedCoffee(promptResources, decoratedCoffee,
                    milkResource);
        } else if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(sugarResource))) {
            return new SimpleDecoratedCoffee(promptResources, decoratedCoffee,
                    sugarResource);
        } else if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(brownieResource))) {
            return new SimpleDecoratedCoffee(promptResources, decoratedCoffee,
                    brownieResource);
        } else if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(pumpkinResource))) {
            return new SeasonalDecoratedCoffee(promptResources,
                    decoratedCoffee, pumpkinResource);
        } else if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(eggnogResource))) {
            return new SeasonalDecoratedCoffee(promptResources,
                    decoratedCoffee, eggnogResource);
        } else if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(chocolateMilkResource))) {
            return new RestrictedDecoratedCoffee(promptResources,
                    decoratedCoffee, chocolateMilkResource);
        } else if (ingredientName.toLowerCase().equals(
                CoffeeFactory.getResourceName(espressoResource))) {
            return new RestrictedDecoratedCoffee(promptResources,
                    decoratedCoffee, espressoResource);
        }

        return decoratedCoffee;
    }

    /**
     * TODO: change to print everything in the englishDecorators.properties file
     */
    public void printMenu() {
        System.out.println(CoffeeFactory.RESOURCES.getString("menu"));
    }
}
