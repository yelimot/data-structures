
public class Item {
	private int number;
	private String name;
	private String compartment;
	private int weight;

	public Item(int number, String name, String compartment, int weight) {
		this.number = number;
		this.name = name;
		this.compartment = compartment;
		this.weight = weight;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCompartment() {
		return compartment;
	}

	public void setCompartment(String compartment) {
		this.compartment = compartment;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object Obj){
		Item other = (Item) Obj;
		if (this.name.equals(other.name) && this.compartment.equals(other.compartment)) {
			return true;
		} else { return false; }
    }
	
	public String toString(){
        return name + " " + compartment + " " + weight;
    }
	
}
