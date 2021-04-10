
public class Dresser implements IProduct {
	
	private String name;
	
	public Dresser(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isManufactured() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isStored() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isSold() {
		// TODO Auto-generated method stub
		return false;
	}

}
