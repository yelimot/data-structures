import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		FileIO fileReader = new FileIO();
		
		Food[] foods = fileReader.foodReader();
		Restaurant[] restaurants = fileReader.restaurantReader();
		 
		// Creating the binary search trees with respect to different attributes
		// such as price, stock, restaurant rating, and delivery time.
		
		// food tree by price
		BST<Food> bstFoodByPrice = new BST<Food>();
		for (int i = 0; i<20; i++) {
			bstFoodByPrice.addByPrice(foods[i]);
		}	
		
		// food tree by stock
		BST<Food> bstFoodByStock = new BST<Food>();
		for (int i = 0; i<20; i++) {
			bstFoodByStock.addByStock(foods[i]);
		}
		
		// restaurant tree by rating
		BST<Restaurant> bstRestaurantByRating = new BST<Restaurant>();
		for (int i = 0; i<20; i++) {
			bstRestaurantByRating.addByRating(restaurants[i]);
		}
		
		// restaurant tree by delivery time
		BST<Restaurant> bstRestaurantByDeliveryTime = new BST<Restaurant>();
		for (int i = 0; i<20; i++) {
			bstRestaurantByDeliveryTime.addByTime(restaurants[i]);
		}
		
		// 1) List the names and ratings of the restaurants in descending order of rating.
		System.out.println("----- 1 -----");
		bstRestaurantByRating.inorderTraverseDescendingRestaurant(bstRestaurantByRating.getRoot());
		
		// 2) List the names, prices, and stocks of the food in ascending order of price.
		System.out.println("----- 2 -----");
		bstFoodByPrice.inorderTraverseAscendingFood(bstFoodByPrice.getRoot());
		
		// 3) Print the name of the Pizza restaurant that has the shortest delivery time.
		System.out.println("----- 3 -----");
		Restaurant fastestPizzaRestaurant = bstRestaurantByDeliveryTime.shortestDeliveryTimePizza(bstRestaurantByDeliveryTime.getRoot());
		System.out.println(fastestPizzaRestaurant.getName() + "   " + fastestPizzaRestaurant.getDeliveryTime());
		
		// 4) Print the name of the Coffee with the highest amount of stock.
		System.out.println("----- 4 -----");
		Food theMostCoffee = bstFoodByStock.theMostCoffeeStock(bstFoodByStock.getRoot());
		System.out.println(theMostCoffee.getName() + "   " + theMostCoffee.getStock());

		// 5) List and remove the foods (from Food BST) that are more expensive than 80 TRY
		System.out.println("----- 5 -----");
		bstFoodByPrice.removeFood(bstFoodByPrice.getRoot());
		
		// 6) List and remove the restaurants (from Restaurant BST) that are rated less than 8.0.
		System.out.println("----- 6 -----");
		bstRestaurantByRating.removeRestaurant(bstRestaurantByRating.getRoot());
		
		// 7) Increase all food prices by 20% (use the updatePrice method).
		bstFoodByPrice.updatePriceTraversal(bstFoodByPrice.getRoot());
		System.out.println("----- 7 -----\n" + "Prices in FoodBSTs are updated.");
		
		// 8) Cut all food stocks by half (use the updateStock method).
		bstFoodByPrice.updateStockTraversal(bstFoodByPrice.getRoot());
		System.out.println("----- 8 -----\n" + "Stocks in FoodBSTs are updated.");
		
		// 9) List the names and ratings of the restaurants in descending order of rating. (Like Step 1).
		System.out.println("----- 9 -----");
		bstRestaurantByRating.inorderTraverseDescendingRestaurant(bstRestaurantByRating.getRoot());
		
		// 10) List the names, prices, and stocks of the food in ascending order of price. (Like Step 2).
		System.out.println("----- 10 -----");
		bstFoodByPrice.inorderTraverseAscendingFood(bstFoodByPrice.getRoot());
		
	}
}
