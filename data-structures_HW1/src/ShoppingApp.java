
import java.util.Scanner; 

public class ShoppingApp {
	
	public static <T> int getLength(T[] arr){
	    int count = 0;
	    for(T el : arr)
	        if (el != null)
	            ++count;
	    return count;
	}
	
	public static void main(String[] args){
	
		Item[] invBag; //creates inventory bag
		invBag = FileIO.readInventory(); // adding items to inventory bag from txt file to
		IBag<Item> s_b = new BasketCompartment(2000); //creates fridge for each compartment (18-23)
		IBag<Item> m_c = new BasketCompartment(5000);
		IBag<Item> s_c = new BasketCompartment(2000);
		IBag<Item> b_c = new BasketCompartment(4000);
		IBag<Item> vf_c = new BasketCompartment(3000);
		
		while(true){ //
			@SuppressWarnings("resource")
			Scanner userInput = new Scanner(System.in); // takes input from user
			System.out.println("Please select an option:");
			System.out.println("[1]Go to shopping");
			System.out.println("[2]See status of the fridge");
			System.out.println("[3]Exit");
			int userOption1 = userInput.nextInt();  // reads user input

    		if(userOption1 == 1){
				while(true){
					System.out.println("Please select an option:");
					System.out.println("[1]Add an item to basket");
					System.out.println("[2]See the basket");
					System.out.println("[3]Finish shopping");
					
					int userOption2 = userInput.nextInt();  // reads user input
					
					if(userOption2 == 1){//lists items inside the inventory bag, adds selected items to basket		
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
					
					else if(userOption2 == 2){ // lists items inside the basket
						System.out.print("Basket contains: ");
						s_b.displayItems();
						continue;
					}
					
					else if(userOption2 == 3){ // finishes the shopping  and adds items to necessary fridge compartment
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
						s_b.dump(); //resets basket
						System.out.println("The fridge is filled.");
						break;
					}
					else { //for invalid inputs 
						System.out.println("Invalid input.");
					}
			
				}
				
    		}
			else if(userOption1 == 2){ //displays capacities of the comparment inside the fridge
				System.out.println("Remaining capacities of each compartments:");
				System.out.println("Vegetables and Fruits: " + vf_c.getCAPACITY() + " grams");
				System.out.println("Meats: " + m_c.getCAPACITY() + " grams");
				System.out.println("Beverages: " + b_c.getCAPACITY() + " grams");
				System.out.println("Snacks: " + s_c.getCAPACITY() + " grams");
			}
			else{ // exits from the program
				System.out.println("Exiting...");
				break;
			}
			break;
		}
		
	}

}
