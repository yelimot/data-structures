
public class Process implements IProcess {
	private String type;
	private int priority;
	
	public Process() {
		this.type = null;
		this.priority = 0;
	}
	
	public Process(String type, int priority) {
		this.type = type;
		this.priority = priority;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public String toString() {
		 return getClass().getName()+"@"+Integer.toHexString(hashCode());
	}

}


