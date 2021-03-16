public class VegetablesFruitsCompartment<Item> implements IBag<Item> {

    private Item[] VFC;
	private int lastIndex;
	private int VFC_CAPACITY;
	
	public VegetablesFruitsCompartment() {
		Item[] tmpBag = (Item[]) new Object[11];
		VFC = tmpBag;
		lastIndex = 0;
		VFC_CAPACITY = 3000;
	}

    public int getVFC_size() {
		return VFC_CAPACITY;
	}

	public void setVFC_size(int VFC_size) {
		VFC_CAPACITY = VFC_size;
	}

    public boolean add(Item newItem) {
		boolean result = true;
		if (newItem.getWeight() > VFC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			}
			
		else if (isFull()) {
			result = false;
			System.out.println("Compartment is full.");
			}
		else {
			VFC[lastIndex] = newItem;
			lastIndex++; 
			System.out.println(newItem.getName() + "is added to the basket.");			
			VFC_CAPACITY -= newItem.getWeight();
			}
		return result;
		}

    public boolean isEmpty() {
		return (lastIndex == 0);
		}
	
	public boolean isFull() {
		return (VFC_CAPACITY <= 0);
		}
    
}