import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		FileIO fileReader = new FileIO();
		
		Food[] foods = fileReader.foodReader();
		Restaurant[] restaurants = fileReader.restaurantReader();
		
//		for (int i = 0; i<20; i++) {
//			System.out.println(foods[i].getName());
//			System.out.println(restaurants[i].getName());
//		}
		 
		// Creating the binary search trees with respect to different attributes
		// such as price, stock, restaurant rating, and delivery time.
		
		BST<Food> bstFoodByPrice = new BST<Food>();
		for (int i = 0; i<20; i++) {
			bstFoodByPrice.addByPrice(foods[i]);
		}	
		
		BST<Food> bstFoodByStock = new BST<Food>();
		for (int i = 0; i<20; i++) {
			bstFoodByStock.addByStock(foods[i]);
		}
		
		BST<Restaurant> bstRestaurantByRating = new BST<Restaurant>();
		for (int i = 0; i<20; i++) {
			bstRestaurantByRating.addByRating(restaurants[i]);
		}
		
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
		
//		
//		
//		
//		System.out.println("----- 3 -----");
//		bstRestaurantByDeliveryTime.shortestDeliveryTimePizza(bstRestaurantByDeliveryTime.getRoot());
	}
}
