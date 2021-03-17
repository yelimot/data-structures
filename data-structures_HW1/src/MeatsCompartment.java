
public class MeatsCompartment implements IBag<Item>{
	
	private Item[] MC;
	private int lastIndex;
	private int MC_CAPACITY;
	
	public MeatsCompartment(int capacity) {
		Item[] tmpBag = new Item[11];
		MC = tmpBag;
		lastIndex = 0;
		MC_CAPACITY = capacity;
	}
	
	public int getMC_size() {
		return MC_CAPACITY;
	}

	public void setMC_size(int MC_size) {
		MC_CAPACITY = MC_size;
	}
	
	public boolean add(Item newItem) {
		boolean result = true;
		
		if (isFull()) {
			System.out.println("Compartment is full.");
			result = false ;
			}

		else if (newItem.getWeight() > MC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			
			}
		else {
			MC[lastIndex] = newItem;
			lastIndex++; 
			System.out.println(newItem.getName() + "is added to the basket.");			
			MC_CAPACITY -= newItem.getWeight();
			}
		return result;
		}
	
	public boolean isEmpty() {
		return (lastIndex == 0);
		}
	
	public boolean isFull() {
		if (MC_CAPACITY == 0){
			return true;
		}
		return false;
		}
	
	public Item removeByIndex(int index) {
		Item result = null;
		if(!isEmpty() && index >= 0) {
			result= MC[index];
			MC[index] = MC[lastIndex-1];
			MC[lastIndex-1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove() {
		Item result = null;
		if(lastIndex > 0) {
			result = MC[lastIndex - 1];
			MC[lastIndex - 1] = null;
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
			if (item.equals(MC[i])) {
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
		while(MC[i] != null) {
			if(!MC[i].equals(MC[i+1]))
				System.out.println(MC[i].toString());
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
