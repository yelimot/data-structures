
public class Simulation<T> {
	private ComputationQueue<T> headQueue;
	private int listLength;
	
	public Simulation() {
		this.headQueue = null;
		this.listLength = 0;
	}

	public void insert(ComputationQueue<T> CQ) {
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
	
	public ComputationQueue<T> getCQ(String name) {
		ComputationQueue<T> var = headQueue;
		for(int i=0;i<listLength;i++) {
			if(var.getName() == name)
				return var;
			else
				var=var.getNext();
		}
		return headQueue;
	}
	
	public boolean isEmpty() {
		return listLength<1;
	}

}
