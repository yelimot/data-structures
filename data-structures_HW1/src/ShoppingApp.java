
import java.util.Scanner; 

public class ShoppingApp {
	
	public static <T> int getLength(T[] arr){
	    int count = 0;
	    for(T el : arr)
	        if (el != null)
	            ++count;
	    return count;
	}
	
	public static void main(String[] args)  {
	
		Item[] invBag;
		invBag = FileIO.readInventory();
		IBag<Item> s_b = new BasketCompartment(2000);
		IBag<Item> m_c = new BasketCompartment(5000);
		IBag<Item> s_c = new BasketCompartment(2000);
		IBag<Item> b_c = new BasketCompartment(4000);
		IBag<Item> vf_c = new BasketCompartment(3000);

		while(true){
			
			@SuppressWarnings("resource")
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please select an option:");
			System.out.println("[1]Go to shopping");
			System.out.println("[2]See status of the fridge");
			System.out.println("[3]Exit");
			int userOption1 = userInput.nextInt();  // Read user input

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
						s_b.add(invBag[selectItem-1]);
						if(s_b.isFull()) {
							System.out.println("The basket is full now.\n Shopping is finished and going to fill the fridge.");							
							for(int j = 0; j < (getLength(s_b.getIArray())) ;j++){
								if ((s_b.getIArray()[j].getCompartment().equals("meats")) && (!m_c.isFull())) {
									m_c.add(s_b.getIArray()[j]);
								}
								else if ((s_b.getIArray()[j].getCompartment().equals("snacks")) && (!s_c.isFull())) {
									s_c.add(s_b.getIArray()[j]);
								}
								else if ((s_b.getIArray()[j].getCompartment().equals("beverages")) && (!b_c.isFull())) {
									b_c.add(s_b.getIArray()[j]);
								}
								else if ((s_b.getIArray()[j].getCompartment().equals("vegetables and fruits")) && (!vf_c.isFull())) {
									vf_c.add(s_b.getIArray()[j]);
								}
							}
							s_b.dump();
							System.out.println("The fridge is filled.");
							break;
						}
						continue;
					}
					
					else if(userOption2 == 2){
						System.out.print("Basket contains: ");
						s_b.displayItems();
						continue;
					}
					
					else if(userOption2 == 3){
						System.out.print("Shopping is finished and going to fill the fridge.");	
						for(int j = 0; j < (getLength(s_b.getIArray())) ;j++){
							if ((s_b.getIArray()[j].getCompartment().equals("meats")) && !(m_c.isFull())) {
								m_c.add(s_b.getIArray()[j]);
							}
							else if ((s_b.getIArray()[j].getCompartment().equals("snacks")) && !(s_c.isFull())) {
								s_c.add(s_b.getIArray()[j]);
							}
							else if ((s_b.getIArray()[j].getCompartment().equals("beverages")) && !(b_c.isFull())) {
								b_c.add(s_b.getIArray()[j]);
							}
							else if ((s_b.getIArray()[j].getCompartment().equals("vegetables and fruits")) && !(vf_c.isFull())) {
								vf_c.add(s_b.getIArray()[j]);
							}
						}
						s_b.dump();
						System.out.println("The fridge is filled.");
						break;
					}
					else {
						System.out.println("Invalid input.");
					}
			
				}
				
    		}
			else if(userOption1 == 2){
				System.out.println("Remaining capacities of each compartments:");
				System.out.println("Vegetables and Fruits: " + vf_c.getCAPACITY() + " grams");
				System.out.println("Meats: " + m_c.getCAPACITY() + " grams");
				System.out.println("Beverages: " + b_c.getCAPACITY() + " grams");
				System.out.println("Snacks: " + s_c.getCAPACITY() + " grams");
			}
			else{
				System.out.println("Exiting...");
				break;
			}
			break;
		}
		
	}

}
