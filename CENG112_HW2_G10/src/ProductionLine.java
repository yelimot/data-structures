
public class ProductionLine<T> implements IQueue<T> { // This class implements queue data structure with no additional method.

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	
	public int getFrontIndex() {
		return frontIndex;
	}

	public void setFrontIndex(int frontIndex) {
		this.frontIndex = frontIndex;
	}

	public int getBackIndex() {
		return backIndex;
	}

	public void setBackIndex(int backIndex) {
		this.backIndex = backIndex;
	}

	public T[] getQueue() {
		return queue;
	}

	public void setQueue(T[] queue) {
		this.queue = queue;
	}

	public ProductionLine(int size) {		
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[size+1];
			setQueue(tempQueue);
			frontIndex = 0;
			backIndex = size;
		}

	public void enqueue(T newEntry) {
		ensureCapacity();
		backIndex = (backIndex + 1) % getQueue().length;
		getQueue()[backIndex] = newEntry;
	}

	public T dequeue() {
		T front =  null;
		if(!isEmpty()) {
			front = getQueue()[frontIndex];
			getQueue()[frontIndex] = null;
			frontIndex = (frontIndex + 1) % getQueue().length;
		}
		return front;
	}

	public T getFront() {
		T front = null;
		if(!isEmpty()) {
			front = getQueue()[frontIndex];
		}
		return front;
	}

	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % getQueue().length);
	}

	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}	
	}
	
	private void ensureCapacity() {		
			if(frontIndex == (backIndex + 2) % getQueue().length) {
				T[] oldQueue = getQueue();
				int oldSize = oldQueue.length;
				int newSize = 2*oldSize;
				@SuppressWarnings("unchecked")
				T[] tempQueue = (T[]) new Object[newSize];
				setQueue(tempQueue);
				for(int index = 0; index < oldSize - 1; index++) {
					getQueue()[index] = oldQueue[frontIndex];
					frontIndex = (frontIndex + 1) % oldSize;
				}
				frontIndex = 0;
				backIndex = oldSize -2;
			}
	}

}
