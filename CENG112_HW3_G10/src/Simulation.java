
public class Simulation<T> {
	// this simulation class constructed according to linked list adt.
	// each simulation (queue) linked with each other by this linked list fashion.
	private ComputationQueue<T> headQueue;
	private int listLength;
	
	public Simulation() { // constructor for simulation class
		this.headQueue = null;
		this.listLength = 0;
	}

	public void insert(ComputationQueue<T> CQ) { // adds 'computation queues' to the  simulation
		if(isEmpty())
			headQueue = CQ;
		else {
			ComputationQueue<T> last = null;
			ComputationQueue<T> now = headQueue;
			for(int i=0; i<listLength; i++) {
				if(i==listLength-1)
					last = now;
				else {
					now = now.getNext();}
			}
			last.setNext(CQ);
		}
		listLength++;
	}
	
	public ComputationQueue<T> getCQ(String name) { //returns specific 'computation queue'
		ComputationQueue<T> var = headQueue;
		for(int i=0;i<listLength;i++) {
			if(var.getName() == name)
				return var;
			else
				var=var.getNext();
		}
		return headQueue;
	}
	
	public boolean isEmpty() { // checks whether the simulation is empty.
		return listLength<1;
	}
}
