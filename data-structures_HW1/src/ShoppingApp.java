import java.util.Scanner; 
public class ShoppingApp {
	public static void main(String[] args) {
		
		Item[] abc;
		
		abc = FileIO.readInventory();
		System.out.println("ramo");

		while(true){
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please select an option:");
			System.out.println("[1]Go to shopping");
			System.out.println("[2]See status of the fridge");
			System.out.println("[3]Exit");
			int userOption = userInput.nextInt();  // Read user input
    		if(userOption == 1){
				while(true){
					System.out.println("Please select an option:");
					System.out.println("[1]Add an item to basket");
					System.out.println("[2]See the basket");
					System.out.println("[3]Finish shopping");
					int userOption2 = userInput.nextInt();  // Read user input
					if(userOption2 == 1){
						System.out.println("Please select an item:");
						for (int i = 0; i < abc.length i++) {
							System.out.println("[ " +i + " ] "+ abc[i].getName());
						}
						int selectItem = userInput.nextInt();
						// itemi seçince baskete ekleme işlemi yapılacak
						// if basket == full ise break atılacak.
						}
					else if(userOption2 == 2){
						// prints basket 
						}
					else{
						// finish shopping yani 3 durumu
						break;
					}

					break;
					}
			}
			else if(userOption == 2){
				// Remaning capatity'ler gösterilecek
				// Örneğin meets 2000 , snacks 320 gibi gibi
				}
			else{
				// optin == 3 yani exit işlemi.
				break;
			}
		}
		
	}


}
