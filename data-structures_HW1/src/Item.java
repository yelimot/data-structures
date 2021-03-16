
public class Item {
	private String name;
	private String compartment;
	private int weight;

	public Item(String name, String compartment, int weight) {
		this.name = name;
		this.compartment = compartment;
		this.weight = weight;
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
		// iþlem yapýlacak
        return true;
    }
	
	public String toString(){
        return name + " " + compartment + " " + weight;
    }
	
}
