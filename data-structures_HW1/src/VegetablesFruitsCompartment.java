
public class VegetablesFruitsCompartment implements IBag<Item> {

    private Item[] VFC;
	private int lastIndex;
	private int VFC_CAPACITY;
	
	public VegetablesFruitsCompartment(int capacity) {
		Item[] tmpBag = new Item[11];
		VFC = tmpBag;
		lastIndex = 0;
		VFC_CAPACITY = capacity;
	}

    public int getVFC_size() {
		return VFC_CAPACITY;
	}

	public void setVFC_size(int VFC_size) {
		VFC_CAPACITY = VFC_size;
	}

	public boolean add(Item newItem) {
		boolean result = true;
		
		if (isFull()) {
			System.out.println("Compartment is full.");
			result = false ;
			}

		else if (newItem.getWeight() > VFC_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			
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
		if (VFC_CAPACITY == 0){
			return true;
		}
		return false;
		}

	public Item removeByIndex(int index) {
		Item result = null;
		if(!isEmpty() && index >= 0) {
			result= VFC[index];
			VFC[index] = VFC[lastIndex-1];
			VFC[lastIndex-1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove() {
		Item result = null;
		if(lastIndex > 0) {
			result = VFC[lastIndex - 1];
			VFC[lastIndex - 1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove(Item item) {
		int index = getIndexOf(item);
		Item result = removeByIndex(index);
		return result;
		}

	public int getItemCount(Item item) {
		int count = 0;
		for (int index=0; index<lastIndex; index++) {
			if(item.equals(VFC[index])) {
				count++;
				}
			}
		return count;
		}
	
	public int getIndexOf(Item item) {
		int whereIsIt = -1;
		boolean place = false;
		int i = 0;
		while(!place && (i < lastIndex)) {
			if (item.equals(VFC[i])) {
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
		while(VFC[i] != null) {
			if(!VFC[i].equals(VFC[i+1]))
				System.out.println(VFC[i].toString());
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
