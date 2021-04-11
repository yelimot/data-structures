
public class Customer <T> {
	
	private Warehouse<T> userWarehouse = new Warehouse<T>(15);  // creates user warehouse
	
	public Customer() {} // constructor
	

	public void operation(boolean isEmpty, IProduct product){
		if(!isEmpty){
			System.out.println("Customer buying "+product.getName()+
			", SUCCESS, Customer bought "+product.getName());
		}
		else{
			System.out.println("Customer buying "+product.getName()+
			", FAIL,"+product.getName()+" warehouse is empty");
		}
	}

	// Request a product (since requested product will deleted from related warehouse after buying, 
	// storage chief also a parameter for this function). 
	public void request(StorageChief<T> storage, IProduct product) {
		if( ((IProduct)product).getName().equals("Sofa")){
			if(!storage.sofaWarehouse.isEmpty()) {
				userWarehouse.push(storage.sofaWarehouse.pop()); // one line - 2 functions (pop from warehouse, push to userWarehouse)
				operation(false, (IProduct)product);
			}
		else {
				operation(true, (IProduct)product);
			}
		}
		else if( ((IProduct)product).getName().equals("Bed" )){
			if(!storage.bedWarehouse.isEmpty()) {
				userWarehouse.push(storage.bedWarehouse.pop());
				operation(false, (IProduct)product);
			}
			else {
				operation(true, (IProduct)product);
			}
		}
		else if( ((IProduct)product).getName().equals("Chair")){
			if(!storage.chairWarehouse.isEmpty()) {
				userWarehouse.push(storage.chairWarehouse.pop());
				operation(false, (IProduct)product);
			}
			else {
				operation(true, (IProduct)product);
			}
		}
		else if( ((IProduct)product).getName().equals("Dresser" )){
			if(!storage.dresserWarehouse.isEmpty()) {
				userWarehouse.push(storage.dresserWarehouse.pop());
				operation(false, (IProduct)product);
			}
			else {
				operation(true, (IProduct)product);
			}
		}
		else if( ((IProduct)product).getName().equals("Table" )){
			if(!storage.tableWarehouse.isEmpty()) {
				userWarehouse.push(storage.tableWarehouse.pop());
				operation(false, (IProduct)product);
			}
			else {
				operation(true, (IProduct)product);
			}
		}
		else if( ((IProduct)product).getName().equals("Bookcase")){
			if(!storage.bookcaseWarehouse.isEmpty()) {
				userWarehouse.push(storage.bookcaseWarehouse.pop()); 
				operation(false, (IProduct)product);
			}
			else {
				operation(true, (IProduct)product);
			}
		}
	}
	
	// customer reports what she/he bought
	public void soldReport() {
		int bedNo = 0;
		int sofaNo = 0;
		int dresserNo = 0;
		int tableNo = 0;
		int chairNo = 0;
		int bookcaseNo = 0;
		
		int i = 0;
		while(userWarehouse.getStack()[i] != null) {
			if(((IProduct)userWarehouse.getStack()[i]).getName().equals("Bed")) {
				bedNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName().equals("Sofa")) {
				sofaNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName().equals("Dresser")) {
				dresserNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName().equals("Table")) {
				tableNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName().equals("Chair")) {
				chairNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName().equals("Bookcase")) {
				bookcaseNo++;
				i++;
			}      
		}
		System.out.println("Amount of Bed Sold: " + bedNo); 
		System.out.println("Amount of Sofa Sold: " + sofaNo);  
		System.out.println("Amount of Dresser Sold: " + dresserNo);  
		System.out.println("Amount of Table Sold: " + tableNo);  
		System.out.println("Amount of Chair Sold: " + chairNo);  
		System.out.println("Amount of Bookcase Sold: " + bookcaseNo + "\n");  
	}
}
