
public class MeatsCompartment<Item> implements IBag<Item>{
	
	private Item[] MC;
	private int lastIndex;
	private int MC_CAPACITY;
	
	public MeatsCompartment() {
		Item[] tmpBag = (Item[]) new Object[11];
		MC = tmpBag;
		lastIndex = 0;
		MC_CAPACITY = 5000;
	}
	
	public boolean add(Item newItem) {
		boolean result = true;
		if (isFull()) {
			result = false;
			// warning message comes here.
			}
		else {
			MC[lastIndex] = newItem;
			lastIndex++; 
			// dolmadan önceki son zz
			MC_CAPACITY -= newItem.getWeight();}
		return result;
		}
	
	public boolean isEmpty() {
		return (lastIndex == 0);
		}
	
	public boolean isFull() {
		// erken biterse deðiþkenden çýkar
		return (MC_CAPACITY <= 499);
		}

	public int getMC_size() {
		return MC_CAPACITY;
	}

	public void setMC_size(int mC_size) {
		MC_CAPACITY = mC_size;
	}

}
