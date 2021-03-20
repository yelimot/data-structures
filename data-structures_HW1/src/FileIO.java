import java.io.BufferedReader;
import java.io.FileNotFoundException;  // Imports necessary dependency 
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	public FileIO(){} // constructor for fileıo

	        public static Item[] readInventory() {
			Item[] inventoryBag = new Item[14]; //creates inventory bag
			
			FileReader FReader;
			BufferedReader BReader;
			
			try{ // file read operations
			FReader = new FileReader("../inventory.txt");
			BReader = new BufferedReader(FReader);
			String line = BReader.readLine();
			
			int i = 0;
			while (line != null) {
				String[] arrOfStr = line.split(",", 3);
				Item item = new Item(i+1, arrOfStr[0], arrOfStr[1], Integer.parseInt(arrOfStr[2])); //creates items
				inventoryBag[i] = item; // adds item to inventory bag
				i++;
				line = BReader.readLine();
				}
			
			}			
			catch(FileNotFoundException ex){ // catchs exception
				 System.out.println("File is not found.");
			 }
			 catch(IOException ex) {
				 System.out.println("Error is found.");
			 }
			

  
			return inventoryBag; // returns inventory bag
	    }

}
