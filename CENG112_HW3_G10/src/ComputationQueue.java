
public class ComputationQueue<T> implements IPriorityQueue<T> {
	private Computation<T> firstNode;
	private Computation<T> lastNode;
	private int queueLength;
	private int totalWaitingTime;
	
	public void ComputationQueue() {
		this.firstNode = null;
		this.lastNode = null;
		this.queueLength = 0;
		this.setTotalWaitingTime(0);
	}

	public Computation<T> getfirstNode() {
		return firstNode;
	}

	public void setfirstNode(Computation<T> head) {
		this.firstNode = head;
	}

	public Computation<T> getlastNode() {
		return lastNode;
	}

	public void setlastNode(Computation<T> last) {
		this.lastNode = last;
	}

	public int getQueueLength() {
		return queueLength;
	}

	public void setQueueLength(int queueLength) {
		this.queueLength = queueLength;
	}

	public int getTotalWaitingTime() {
		return totalWaitingTime;
	}

	public void setTotalWaitingTime(int totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
	}
	
	/*
	// Insert to the queue and increase queueLength.
	public void insert(Computation<T> newComputation) {
		if (isEmpty()) {
			firstNode = newComputation;
			lastNode = newComputation;
		} else {
			firstNode.setNext(newComputation);
			lastNode = newComputation;
		}
		queueLength++;
	}
	*/
	
	public Computation<T> getReferenceTo(Computation<T> entry){
		boolean found=false;
		Computation<T> current = firstNode;
		while(!found && (current!=null)) {
			if(entry==current)
				found=true;
			else
				current=current.getNext();
		}
		return current;
	}
	
	public void insert(Computation<T> T) {
		boolean done = false;
		Computation<T> tempComputation1 = null;
		Computation<T> tempComputation2;
		tempComputation2 = getReferenceTo(firstNode);
		while(!done) {
			if(tempComputation2==null) {
				enqueue(T);
				done = true;
			}
			else if (tempComputation2.getProcess().getPriority() > T.getProcess().getPriority()) {
				if(tempComputation1 == null) {
					T.setNext(firstNode.getNext());
					this.firstNode = T;
					this.queueLength++;
					this.totalWaitingTime += T.getOccupation();
					done=true;
				}
				else {
					T.setWait(this.totalWaitingTime);
					T.setNext(tempComputation1);
					tempComputation1.setNext(T);
					this.queueLength++;
					this.totalWaitingTime += T.getOccupation();
					done = true;
				}
			}
			else if (tempComputation2.getProcess().getPriority() == T.getProcess().getPriority()) {
				tempComputation1 = getReferenceTo(tempComputation2);
				tempComputation2 = getReferenceTo(tempComputation2.getNext());
			}
			else {
				tempComputation1 = getReferenceTo(tempComputation2);
				tempComputation2 = getReferenceTo(tempComputation2.getNext());
			}
		}
	}
	 

	public Computation remove() {
		// Removes first computation and return it.
		Computation temp = firstNode;
		if (!isEmpty()) {
			firstNode = firstNode.getNext();
		}
		return temp;
	}
	
	public void enqueue(Computation<T> newComer) {
		Computation<T> newNode = new Computation<T>(newComer.getId(), newComer.getProcess(), newComer.getOccupation(), newComer.getWait(), null);
		if(isEmpty())
			this.firstNode = newNode;
		else
			this.lastNode.setNext(newNode);
		this.lastNode = newNode;
		this.queueLength++;
		this.totalWaitingTime += newComer.getOccupation();
	}
	
	public Computation<T> getFront() {
		if(isEmpty())
			return null;
		else
			return firstNode;
	}
		
	@SuppressWarnings("unchecked")
	public T dequeue() {
		if(isEmpty())
			return null;
		else {
			queueLength--;
			totalWaitingTime -= firstNode.getOccupation();
			Computation<T> front = getFront();
			firstNode.setProcess(null);
			firstNode.setId(0);
			firstNode.setOccupation(0);
			firstNode.setWait(0);
			firstNode = this.firstNode.getNext();
			if(firstNode == null)
				lastNode = null;
			return (T)front;
			}
	}
	
	public boolean isEmpty(){
	    return (firstNode == null) && (lastNode == null);
	}
	
	public void clear(){
	    firstNode = null; 
	    lastNode = null;
	}
	
	
	



	

}
