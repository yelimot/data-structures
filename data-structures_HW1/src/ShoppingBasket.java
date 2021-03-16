
public class ShoppingBasket<Item> implements IBag<Item>{
	
	private Item[] SB;
	private int lastIndex;
	private int SB_CAPACITY = 2000;
	
	public ShoppingBasket() {
		Item[] tmpBag = (Item[]) new Object[11];
		SB = tmpBag;
		lastIndex = 0;
	}
	
	public int getSB_size() {
		return SB_CAPACITY;
	}

	public void setSB_size(int SB_size) {
		SB_CAPACITY = SB_size;
	}
	
	public boolean add(Item newItem) {
		boolean result = true;
		if (newItem.getWeight() > SB_CAPACITY) {
			System.out.println("Item weight exceeds remaining capacity.");
			result = false;
			}
			
		else if (isFull()) {
			result = false;
			System.out.println("Compartment is full.");
			}
		else {
			SB[lastIndex] = newItem;
			lastIndex++; 
			System.out.println(newItem.getName() + "is added to the basket.");			
			SB_CAPACITY -= newItem.getWeight();
			}
		return result;
		}
	
	public boolean isEmpty() {
		return (lastIndex == 0);
		}
	
	public boolean isFull() {
		return (SB_CAPACITY <= 0);
		}
	
	public Item removeByIndex(int index) {
		Item result = null;
		if(!isEmpty() && index >= 0) {
			result= SB[index];
			SB[index] = SB[lastIndex-1];
			SB[lastIndex-1] = null;
			lastIndex--;
			}
		return result;
		}
	
	public Item remove() {
		Item result = null;
		if(lastIndex > 0) {
			result = SB[lastIndex - 1];
			SB[lastIndex - 1] = null;
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
			if(item.equals(SB[index])) {
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
			if (item.equals(SB[i])) {
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
		while(SB[i] != null) {
			if(!SB[i].equals(SB[i+1]))
				System.out.println(SB[i].toString());
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
