
public interface IBag<T> { // interface for IBag
	
	public boolean add(T newItem);	// add item to basket array
	public boolean isFull();//checks basket weight is full or not
	public void displayItems(); //displays name of the items inside the basket
	public void dump(); // removes all the items from the bag
	public Item[] getIArray(); // some getter and setter methods(8/13)
	public void setIArray(Item[] iArray);
	public int getNumberOfItems();
	public void setNumberOfItems(int NumberOfItems);
	public int getCAPACITY();
	public void setCAPACITY(int cAPACITY);
}
