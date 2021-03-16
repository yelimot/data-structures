public class BevaragesCompartment<Item> implements IBag<Item> {

    private Item[] BC;
	private int lastIndex;
	private int BC_CAPACITY;
	
	public BevaragesCompartment() {
		Item[] tmpBag = (Item[]) new Object[11];
		BC = tmpBag;
		lastIndex = 0;
		BC_CAPACITY = 4000;
	}

    public int getBC_size() {
		return BC_CAPACITY;
	}

	public void setBC_size(int BC_size) {
		BC_CAPACITY = BC_size;
	}

    public boolean add(Item newItem) {
		boolean result = true;
		if (newItem.getWeight() > BC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			}
			
		else if (isFull()) {
			result = false;
			System.out.println("Compartment is full.");
			}
		else {
			BC[lastIndex] = newItem;
			lastIndex++; 
			System.out.println(newItem.getName() + "is added to the basket.");			
			BC_CAPACITY -= newItem.getWeight();
			}
		return result;
		}
    public boolean isEmpty() {
		return (lastIndex == 0);
		}
	
	public boolean isFull() {
		return (BC_CAPACITY <= 0);
		}
    
}
