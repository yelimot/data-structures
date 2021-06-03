import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	Food[] foodArray = new Food[20];
	Restaurant[] restaurantArray = new Restaurant[20];
	
	public Food[] foodReader() throws IOException {
		
		BufferedReader csvReader = new BufferedReader(new FileReader("CENG112_HW4.csv"));
	    
	    int index = 0;
	    String row = csvReader.readLine();
		while ((row = csvReader.readLine()) != null) {
	   		String[] listOfAttributes = row.split(",");
	   		
	   		Restaurant tmpRestaurant = new Restaurant(listOfAttributes[3], Double.valueOf(listOfAttributes[4]), listOfAttributes[5], Integer.valueOf(listOfAttributes[6]));
	   		Food tmpFood = new Food(listOfAttributes[0], Double.valueOf(listOfAttributes[1]), Integer.valueOf(listOfAttributes[2]), tmpRestaurant);
	   		
	   		restaurantArray[index] = tmpRestaurant;
	   		foodArray[index] = tmpFood;
	   		index++;
	   	}
	       
	    csvReader.close();
	    return foodArray;
	}
	
	public Restaurant[] restaurantReader() {
		return restaurantArray;
	}

}
