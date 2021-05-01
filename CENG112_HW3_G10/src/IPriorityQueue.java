
public interface IPriorityQueue<T> {
	
	public void enqueue(Computation<T> newEntry);
	public T dequeue();
	public Computation<T> getFront();
	public boolean isEmpty();
	public void clear();
	
}