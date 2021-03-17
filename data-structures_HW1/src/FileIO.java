import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; 

public class FileIO {
	FileIO(){}
	    public static Item[] readInventory() {
			Item[] inventoryBag = new Item[14];
			try{
			File myObj = new File("inventory.txt");
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] arrOfStr = data.split(",", 3);
				Item item = new Item(i+1, arrOfStr[0], arrOfStr[1], Integer.parseInt(arrOfStr[2]));
				inventoryBag[i] = item;
				i++;
			}
			myReader.close();}
			catch(FileNotFoundException e){
				System.out.println("T");
			}
			return inventoryBag;
	    }

}
