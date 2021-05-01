
public class Computation<T> {
	private int id; // unique computation id in [1,1000] 
	private IProcess process; // the process that makes computation request
	private int occupation; // needed time for the computation
	private int wait; // remaining time to the execution
	private Computation<T> next; // next computation being held after this
	
	/*
	public Computation(int id, IProcess process, int occupation, int wait) {
		this(id, process, occupation, wait, null);
	}
	*/
	
	public Computation(int id, IProcess process, int occupation, int wait, Computation<T> next) {
		this.id = id;
		this.process = process;
		this.occupation = occupation;
		this.wait = wait;
		this.next = next;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IProcess getProcess() {
		return process;
	}

	public void setProcess(IProcess process) {
		this.process = process;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public Computation<T> getNext() {
		return next;
	}

	public void setNext(Computation<T> next) {
		this.next = next;
	}
	
		
	// public String toString();
	
}
