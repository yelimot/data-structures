
public class ComputationQueue<T> implements IPriorityQueue<T> {
	private Computation<T> firstNode;
	private Computation<T> lastNode;
	private int queueLength;
	private int totalWaitingTime;
	private String name;
	private int queueNo;
	private ComputationQueue<T> next;

	public ComputationQueue(String name, int no) {
		this.firstNode = null;
		this.lastNode = null;
		this.queueLength = 0;
		this.setTotalWaitingTime(0);
		this.name = name;
		this.queueNo = no;
	}

	public int getQueueNo() {
		return queueNo;
	}

	public void setQueueNo(int queueNo) {
		this.queueNo = queueNo;
	}

	public Computation<T> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Computation<T> firstNode) {
		this.firstNode = firstNode;
	}

	public Computation<T> getLastNode() {
		return lastNode;
	}

	public void setLastNode(Computation<T> lastNode) {
		this.lastNode = lastNode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
			/*
						
			if(tempComputation1==null) {
					T.setNext(firstNode.getNext());
					this.firstNode=T;
					this.queueLength++;
					this.totalWaitingTime+=T.getOccupation();
					done=true;
				}
			
			*/
			else if (tempComputation2.getProcess().getPriority() > T.getProcess().getPriority()) {
				if(tempComputation1 == null) {
					Computation<T> temp = firstNode;
					this.firstNode = T;
					firstNode.setNext(temp);
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
	
	public String toString() {
		return getClass().getName()+"@"+Integer.toHexString(hashCode());
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
	
	public ComputationQueue<T> getNext() {
		return this.next;
	}
	
	public void setNext(ComputationQueue<T> next) {
		this.next = next;
	}
	
}
