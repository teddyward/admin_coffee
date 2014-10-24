package brewing;

import java.util.ResourceBundle;
import java.util.Scanner;

import coffeeComponents.Coffee;
import coffeeComponents.SimpleCoffee;

public class CoffeeHouse {
	
	private CoffeeFactory factory;
	
	private ResourceBundle resources;
	private static final String DEFAULT_RESOURCE_LOCATION = "resources.english";
	
	public CoffeeHouse() {
		resources = ResourceBundle.getBundle(DEFAULT_RESOURCE_LOCATION);
		factory = new CoffeeFactory(resources);
	}
	
	public void takeOrder() {
		
	    Scanner scanner = new Scanner( System.in );

	    System.out.println(resources.getString("welcome"));
	    System.out.println(resources.getString("prompt"));
	    System.out.println(resources.getString("instructions"));
	    System.out.println(resources.getString("menu"));
	    
	    String order = scanner.nextLine();
	    
	    Coffee coffee = new SimpleCoffee(resources);
	    for(String ingredient : order.split(",")) {
	    	coffee = factory.makeCoffeeDecorator(coffee, ingredient);
	    }
	    
	    System.out.println(resources.getString("offer") + coffee.getDescription());
	    System.out.println(resources.getString("ingredients") + coffee.getIngredients());
	    System.out.println(resources.getString("charge") + coffee.getCost());
	    
	    scanner.close();
	}
}
