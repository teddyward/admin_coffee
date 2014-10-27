package decoratedCoffee;

import java.util.ResourceBundle;
import java.util.Scanner;

import brewing.CoffeeFactory;
import coffeeComponents.Coffee;

/**
 * This coffee add-on requires folks to have a promo code in order to get it
 *
 * @author Teddy Ward
 * @version 1.0
 */
public class RestrictedDecoratedCoffee extends SimpleDecoratedCoffee {

    private String promoCode;

    private static final int PROMO_CODE_SECTION = 4;
    private static final int NO_CHARGE = 0;
    private static final String NO_DECORATOR = "";

    public RestrictedDecoratedCoffee(ResourceBundle resources,
            Coffee decoratedCoffee, String resourceListing) {
        super(resources, decoratedCoffee, resourceListing);
        promoCode = CoffeeFactory.getSectionFromResourceInfo(resourceListing,
                RestrictedDecoratedCoffee.PROMO_CODE_SECTION);

        requestCode();
    }

    private void requestCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format(resources.getString("promoPrompt"), name));

        String givenCode = scanner.nextLine();
        // if you don't know the code, you don't get the addon
        if (!givenCode.equals(promoCode)) {
            System.out.printf(resources.getString("invalidPromo"), givenCode);
            cost = RestrictedDecoratedCoffee.NO_CHARGE;
            name = RestrictedDecoratedCoffee.NO_DECORATOR;
            description = RestrictedDecoratedCoffee.NO_DECORATOR;
        }
    }

}
