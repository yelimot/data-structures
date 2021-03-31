
public class Product implements IProduct {
	
	private String name;
	private int productNo; // random number oluþtururken belki kolaylýk saðlar
	
	public Product(String name, int productNo) {
		this.name = name;
		this.productNo = productNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
