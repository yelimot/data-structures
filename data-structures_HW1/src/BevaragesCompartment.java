
public class BevaragesCompartment implements IBag<Item>{
	
	private Item[] BC;
	private int lastIndex;
	private int BC_CAPACITY;
	
	public BevaragesCompartment(int capacity) {
		Item[] tmpBag = new Item[11];
		BC = tmpBag;
		lastIndex = 0;
		BC_CAPACITY = capacity;
	}
	
	public int getBC_size() {
		return BC_CAPACITY;
	}

	public void setBC_size(int BC_size) {
		BC_CAPACITY = BC_size;
	}
	
	public boolean add(Item newItem) {
		boolean result = true;
		
		if (isFull()) {
			System.out.println("Compartment is full.");
			result = false ;
			}

		else if (newItem.getWeight() > BC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			
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
		if (BC_CAPACITY == 0){
			return true;
		}
		return false;
		}
	
	public Item removeByIndex(int index) {
		Item result = null;
		if(!isEmpty() && index >= 0) {
			result= BC[index];
			BC[index] = BC[lastIndex-1];
			BC[lastIndex-1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove() {
		Item result = null;
		if(lastIndex > 0) {
			result = BC[lastIndex - 1];
			BC[lastIndex - 1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove(Item item) {
		int index = getIndexOf(item);
		Item result = removeByIndex(index);
		return result;
		}
	
	public int getIndexOf(Item item) {
		int whereIsIt = -1;
		boolean place = false;
		int i = 0;
		while(!place && (i < lastIndex)) {
			if (item.equals(BC[i])) {
				place = true;
				whereIsIt = i;
				}
			i++;
			}
		return whereIsIt;
		}
	
	public boolean contains(Item item) {
		return (getIndexOf(item) > -1);
		}
	
	public void displayItems() {
		int i = 0;
		while(BC[i] != null) {
			if(!BC[i].equals(BC[i+1]))
				System.out.println(BC[i].toString());
			i++;
			}
		}

	public void dump() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	public boolean transferTo(IBag<Item> targetBag, Item item) {
		if(this.contains(item)) {
			targetBag.add(item);
			return true;
		} else {
			return false;
		}
	}

}
