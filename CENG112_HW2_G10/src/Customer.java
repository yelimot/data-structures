
public class Customer <T> {
	
	private Warehouse<T> userWarehouse = new Warehouse<T>(15);  // creates user warehouse
	
	public Customer() {} // constructor
	
	// Request a product (since requested product will deleted from related warehouse after buying, 
	// storage chief also a parameter for this function). 
	public void request(StorageChief<T> storage, IProduct product) {
		if( ((IProduct)product).getName() == "Sofa" ){
			if(!storage.sofaWarehouse.isEmpty()) {
				userWarehouse.push(storage.sofaWarehouse.pop()); // one line - 2 functions (pop from warehouse, push to userWarehouse)
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", SUCCESS, Customer bought "+((IProduct)product).getName());
			}
			else {
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", FAIL,"+((IProduct)product).getName()+" warehouse is empty");
			}
		}
		else if( ((IProduct)product).getName() == "Bed" ){
			if(!storage.bedWarehouse.isEmpty()) {
				userWarehouse.push(storage.bedWarehouse.pop());
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", SUCCESS, Customer bought "+((IProduct)product).getName());
			}
			else {
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", FAIL,"+((IProduct)product).getName()+" warehouse is empty");
			}
		}
		else if( ((IProduct)product).getName() == "Chair" ){
			if(!storage.chairWarehouse.isEmpty()) {
				userWarehouse.push(storage.chairWarehouse.pop());
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", SUCCESS, Customer bought "+((IProduct)product).getName());
			}
			else {
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", FAIL,"+((IProduct)product).getName()+" warehouse is empty");
			}
		}
		else if( ((IProduct)product).getName() == "Dresser" ){
			if(!storage.dresserWarehouse.isEmpty()) {
				userWarehouse.push(storage.dresserWarehouse.pop());
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", SUCCESS, Customer bought "+((IProduct)product).getName());
			}
			else {
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", FAIL,"+((IProduct)product).getName()+" warehouse is empty");
			}
		}
		else if( ((IProduct)product).getName() == "Table" ){
			if(!storage.tableWarehouse.isEmpty()) {
				userWarehouse.push(storage.tableWarehouse.pop());
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", SUCCESS, Customer bought "+((IProduct)product).getName());
			}
			else {
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", FAIL,"+((IProduct)product).getName()+" warehouse is empty");
			}
		}
		else if( ((IProduct)product).getName() == "Bookcase" ){
			if(!storage.bookcaseWarehouse.isEmpty()) {
				userWarehouse.push(storage.bookcaseWarehouse.pop()); 
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", SUCCESS, Customer bought "+((IProduct)product).getName());
			}
			else {
				System.out.println("Customer buying "+((IProduct)product).getName()+
						", FAIL,"+((IProduct)product).getName()+" warehouse is empty");
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
			if(((IProduct)userWarehouse.getStack()[i]).getName() == "Bed") {
				bedNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName() == "Sofa") {
				sofaNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName() == "Dresser") {
				dresserNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName() == "Table") {
				tableNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName() == "Chair") {
				chairNo++;
				i++;
			}
			else if(((IProduct)userWarehouse.getStack()[i]).getName() == "Bookcase") {
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
