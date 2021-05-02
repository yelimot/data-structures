
public interface IPriorityQueue<T> { // interface class for priority queue
	
	public void enqueue(Computation<T> newEntry);
	public Computation<T> dequeue();
	public Computation<T> getFront();
	public boolean isEmpty();
	public void clear();
	
}