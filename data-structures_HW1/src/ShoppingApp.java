
import java.util.Scanner; 

public class ShoppingApp {
	public static void main(String[] args)  {
	
		Item[] invBag;
		invBag = FileIO.readInventory();
		IBag<Item> s_b = new ShoppingBasket(2000);
		IBag<Item> m_c = new MeatsCompartment(5000);
		IBag<Item> s_c = new SnacksCompartment(2000);
		IBag<Item> b_c = new BevaragesCompartment(4000);
		IBag<Item> vf_c = new VegetablesFruitsCompartment(3000);

		while(true){
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please select an option:");
			System.out.println("[1]Go to shopping");
			System.out.println("[2]See status of the fridge");
			System.out.println("[3]Exit");
			int userOption1 = userInput.nextInt();  // Read user input

//			for (int i = 0; i < 14; i++) {
//							System.out.println("["+ (i+1) +"] "+ invBag[i].getName());
//						}
//			
    		if(userOption1 == 1){
				while(true){
					System.out.println("Please select an option:");
					System.out.println("[1]Add an item to basket");
					System.out.println("[2]See the basket");
					System.out.println("[3]Finish shopping");
					
					int userOption2 = userInput.nextInt();  // Read user input
					
					if(userOption2 == 1){			
						System.out.println("Please select an item: ");
						for (int i = 0; i < invBag.length; i++) {
							System.out.println("["+ (i+1) +"] "+ invBag[i].getName());
						}
						int selectItem = userInput.nextInt();
						s_b.add(invBag[selectItem]);
						System.out.println(s_b);
						if(s_b.isFull()) {
							System.out.println("The basket is full now.\n Shopping is finished and going to fill the fridge.");
							for(int j = 0; j < 10 ;j++){
								// s_b class'ýnýn Item arrayine eriþmek gerekmektedir.
							}
							break;
						}
						continue;
					}
					
					else if(userOption2 == 2){
						System.out.print("Basket contains: ");
						s_b.displayItems();
						continue;
					}
					
					else{
						System.out.print("Shopping is finished and going to fill the fridge.");		
						break;
					}
			
				}
				
    		}
			else if(userOption1 == 2){
				System.out.println("Remaining capacities of each compartments:");
				//System.out.println("Vegetables and Fruits: " + vf_c.VFC_CAPACITY);
				System.out.println("optin2");
				System.out.println("optin2");
				System.out.println("optin2");
				System.out.println("optin2");
				}
			else{
				// optin == 3 yani exit iÅŸlemi.
				break;
			}
			break;
		}
		
	}


}
