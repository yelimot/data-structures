import java.io.BufferedReader;
import java.io.FileNotFoundException;  // Imports necessary dependency 
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	public FileIO(){} // constructor for fileIO

	        public static Item[] readInventory() {
			Item[] inventoryBag = new Item[14]; //creates inventory bag
			
			FileReader FReader;
			BufferedReader BReader;
			
			try{						// you need to add 'DIRECT PATH' of your directory here
			FReader = new FileReader("C:\\Users\\myasa\\eclipse-workspace\\data-structures_HW1\\src\\inventory.txt"); 
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
//			catch(FileNotFoundException e){
//				System.out.println("T");
//			}
			
			
			catch(FileNotFoundException ex){ // catches exception
				 System.out.println("File is not found.");
			 }
			 catch(IOException ex) {
				 System.out.println("Error is not found.");
			 }

  
			return inventoryBag; // returns inventory bag
	    }

}
