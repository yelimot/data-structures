
public class ComputationQueue<T> implements IPriorityQueue<T> {
	// The 'computation queue' holds all computations in their order of priority.
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
	
	public void insert(Computation<T> T) { // adds new computation to the queue by controlling priority of its process.
		boolean done = false;
		Computation<T> tempTrans1 = null;
		Computation<T> tempTrans2;
		tempTrans2 = firstNode;
		while(!done) {
			if(tempTrans2 == null) {
				enqueue(T);
				done = true;
				}
			else if(tempTrans2.getProcess().getPriority()<T.getProcess().getPriority()) {
				tempTrans1 = tempTrans2;
				tempTrans2 = tempTrans2.getNext();
				}
			else if(tempTrans2.getProcess().getPriority()==T.getProcess().getPriority()) {
				tempTrans1 = tempTrans2;
				tempTrans2 = tempTrans2.getNext();
			}
			else{
				if(tempTrans1 == null) {
					T.setNext(firstNode.getNext());
					this.firstNode = T;
					this.queueLength++;
					this.totalWaitingTime += T.getOccupation();
					done = true;
				}
				else {
					T.setWait(this.totalWaitingTime);
					T.setNext(tempTrans2);
					tempTrans1.setNext(T);
					this.queueLength++;
					this.totalWaitingTime += T.getOccupation();
					done = true;
				}
			}
		}
	}

	public Computation remove() { // removes first computation and return it.
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
	
	public Computation<T> getFront() { // returns front node of the queue
		if(isEmpty())
			return null;
		else
			return firstNode;
	}
	
	public String toString() {
		return getClass().getName()+"@"+Integer.toHexString(hashCode());
	}
		
	@SuppressWarnings("unchecked")
	public Computation<T> dequeue() {
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
			return (Computation<T>)front;
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
