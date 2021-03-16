public class SnacksCompartment<Item> implements IBag<Item>  {

    private Item[] SC;
	private int lastIndex;
	private int SC_CAPACITY;
	
	public SnacksCompartment() {
		Item[] tmpBag = (Item[]) new Object[11];
		SC = tmpBag;
		lastIndex = 0;
		SC_CAPACITY = 2000;
	}

    public int getSC_size() {
		return SC_CAPACITY;
	}

	public void setSC_size(int SC_size) {
		SC_CAPACITY = SC_size;
	}

    public boolean add(Item newItem) {
		boolean result = true;
		if (newItem.getWeight() > SC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			}
			
		else if (isFull()) {
			result = false;
			System.out.println("Compartment is full.");
			}
		else {
			SC[lastIndex] = newItem;
			lastIndex++; 
			System.out.println(newItem.getName() + "is added to the basket.");			
			SC_CAPACITY -= newItem.getWeight();
			}
		return result;
		}
    public boolean isEmpty() {
		return (lastIndex == 0);
		}
	
	public boolean isFull() {
		return (SC_CAPACITY <= 0);
		}
    
}
