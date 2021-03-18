
public class SnacksCompartment implements IBag<Item>{
	
	private Item[] SC;
	private int lastIndex;
	private int SC_CAPACITY;
	
	public SnacksCompartment(int capacity) {
		Item[] tmpBag = new Item[11];
		SC = tmpBag;
		lastIndex = 0;
		SC_CAPACITY = capacity;
	}
	
	public int getSC_size() {
		return SC_CAPACITY;
	}

	public void setSC_size(int SC_size) {
		SC_CAPACITY = SC_size;
	}
	
	public boolean add(Item newItem) {
		boolean result = true;
		
		if (isFull()) {
			System.out.println("Compartment is full.");
			result = false ;
			}

		else if (newItem.getWeight() > SC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			
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
		if (SC_CAPACITY == 0){
			return true;
		}
		return false;
		}
	
	public Item removeByIndex(int index) {
		Item result = null;
		if(!isEmpty() && index >= 0) {
			result= SC[index];
			SC[index] = SC[lastIndex-1];
			SC[lastIndex-1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove() {
		Item result = null;
		if(lastIndex > 0) {
			result = SC[lastIndex - 1];
			SC[lastIndex - 1] = null;
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
			if (item.equals(SC[i])) {
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
		while(SC[i] != null) {
			if(!SC[i].equals(SC[i+1]))
				System.out.println(SC[i].toString());
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
