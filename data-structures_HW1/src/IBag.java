
public interface IBag<T> {
	public boolean add(T newItem);
	public boolean isEmpty();
	public boolean isFull();
	public T removeByIndex(int index);
	public T remove();
	public T remove(T item);
	public int getItemCount(T item);
	public int getIndexOf(T item);
	public boolean contains(T item);
	public void displayItems();
	public void dump(); // removes all the items from the bag
}
