import java.util.Random;
import java.util.Scanner; 

public class Main {
	public static void main(String[] args){

        IProduct productSofa = new Sofa("Sofa"); // creation of products 
        IProduct productBed = new Bed("Bed");
        IProduct productChair = new Chair("Chair");
        IProduct productDresser = new Dresser("Dresser");
        IProduct productTable = new Table("Table");
        IProduct productBookcase = new Bookcase("Bookcase");
        
        IProduct[] arrayOfProduct = {productSofa, // array of products
					        		productBed,
					        		productChair,
					        		productDresser,
					        		productTable,
					        		productBookcase};
        
		Scanner userInput = new Scanner(System.in);
		System.out.print("Welcome to IZTECHEA!\nHow many times do you want to simulate: ");
		int numberOfSimulate = userInput.nextInt();
		
		Random rand = new Random();
		MarketingAnalyst<IProduct> marketingAnalyst = new MarketingAnalyst<IProduct>(); // creates class objects
        StorageChief<IProduct> storageChief = new StorageChief<IProduct>();
        Customer<IProduct> customer = new Customer<IProduct>();
        
        userInput.close();
        
		for(int i = 0; i<numberOfSimulate; i++) { // simulation starts
			
			int activityNo = rand.nextInt(3); // generates 0-1-2
	        int productNo = rand.nextInt(6); // generates 0-1-2-3-4-5
	        
	        if(activityNo == 0){ // Marketing Analyst operations
	            marketingAnalyst.manufactureFurniture(arrayOfProduct[productNo]);

	        }
	        else if(activityNo == 1){ // Storage Chief operations
	            storageChief.storageFurniture(marketingAnalyst.pLine);
	         
	        }
	        else if(activityNo == 2){ // Customer operations
	        	customer.request(storageChief, arrayOfProduct[productNo]);
	        }	
		}
		System.out.println("\nREPORT: "); // Report functions after simulation done:
		marketingAnalyst.factoryLineReport();
		storageChief.warehouseReport();
		customer.soldReport();
	
	}
}
