
public interface IStack <T> {
	public boolean isEmpty();
    public void push(T newEntry); 
    public T pop();   
    public T peek();   
    public void clear();
}
