package brewing;

/**
 * This is the basic framework for a CoffeeShop app. Only returns basic strings
 * for now, but one could imagine this being part of a larger structure where
 * those strings / values had to be computed in a more complex way.
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class Main {

    public static void main(String args[]) {
        CoffeeHouse chaus = new CoffeeHouse();
        chaus.takeOrder();
    }
}
