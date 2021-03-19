
public interface IBag<T> {
	
	public boolean add(T newItem);	
	public boolean isFull();
	public void displayItems();
	public void dump(); // removes all the items from the bag
	public Item[] getIArray();
	public void setIArray(Item[] iArray);
	public int getNumberOfItems();
	public void setNumberOfItems(int NumberOfItems);
	public int getCAPACITY();
	public void setCAPACITY(int cAPACITY);
}
