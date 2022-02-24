public class BasketCompartment implements IBag<Item>{
	
	private Item[] IArray;//Basket array
	private int NumberOfItems;
	private int CAPACITY;
	private String name;
	
	public BasketCompartment(int capacity, String N) { // constructor of this class
		Item[] tmpBag = new Item[35];
		IArray = tmpBag;
		NumberOfItems = 0;
		CAPACITY = capacity;
		name = N;
	}
	
	public Item[] getIArray() {  // some getter and setter methods (14- 34)
		return IArray;
	}

	public void setIArray(Item[] iArray) {
		IArray = iArray;
	}

	public int getNumberOfItems() {
		return NumberOfItems;
	}

	public void setNumberOfItems(int NumberOfItems) {
		this.NumberOfItems = NumberOfItems;
	}

	public int getCAPACITY() {
		return CAPACITY;
	}

	public void setCAPACITY(int cAPACITY) {
		CAPACITY = cAPACITY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean add(Item newItem) { // add item to basket array
		boolean result = true;
		
		if (isFull()) {
			System.out.println("Compartment is full.");
			result = false;
			}

		else if (newItem.getWeight() > CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			}
		else {
			IArray[NumberOfItems] = newItem;
			NumberOfItems++; 
			System.out.println(newItem.getName() + " is added to the " + this.getName());			
			CAPACITY -= newItem.getWeight();
			}
		return result;
	}
	
	public boolean isFull() { //checks basket weight is full or not
		if (CAPACITY == 0){
			return true;
		}
		return false;
	}
	
	public void displayItems() { //displays name of the items inside the basket
		int i = 0;
		while(IArray[i] != null) {
			System.out.println(IArray[i].getName());
			i++;
		}
	}

	public void dump() { // dumps items inside the baske
		CAPACITY = 2000; // Since we just calling this function only for shopping basket there is no problem exist.
		for(int i = 0; i < NumberOfItems; i++) {
			IArray[i]=null;	
		}
		NumberOfItems = 0;
	}

}
