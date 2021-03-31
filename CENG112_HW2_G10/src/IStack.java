
public interface IStack <T> {
	public boolean isEmpty();
    public boolean isFull();
    public void push(T newEntry); // throws StackFullException;
    public T pop(); // throws StackEmptyException;   
    public T peek(); // throws StackEmptyException;    
    public void clear();
}
