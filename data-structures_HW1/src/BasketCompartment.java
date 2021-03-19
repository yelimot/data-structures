public class BasketCompartment implements IBag<Item>{
	
	private Item[] IArray;
	private int NumberOfItems;
	private int CAPACITY;
	
	public BasketCompartment(int capacity) {
		Item[] tmpBag = new Item[35];
		IArray = tmpBag;
		NumberOfItems = 0;
		CAPACITY = capacity;
	}
	
	public Item[] getIArray() {
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

	public boolean add(Item newItem) {
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
			System.out.println(newItem.getName() + " is added to the name.");			
			CAPACITY -= newItem.getWeight();
			}
		return result;
	}
	
	public boolean isFull() {
		if (CAPACITY == 0){
			return true;
		}
		return false;
	}
	
	public void displayItems() {
		int i = 0;
		while(IArray[i] != null) {
			System.out.println(IArray[i].getName());
			i++;
		}
	}

	public void dump() {
		for(int i = 0; i < NumberOfItems; i++) {
			IArray[i]=null;
		}
	}

}
