
public class StorageChief<T> {
	
	// Since the storageChief deals with all warehouses, 
	// warehouse objects created on its class body as different attributes.
    public Warehouse<T> sofaWarehouse = new Warehouse<>(5);
    public Warehouse<T> bedWarehouse = new Warehouse<>(5);
    public Warehouse<T> chairWarehouse = new Warehouse<>(5);
    public Warehouse<T> dresserWarehouse = new Warehouse<>(5);
    public Warehouse<T> tableWarehouse = new Warehouse<>(5);
    public Warehouse<T> bookcaseWarehouse = new Warehouse<>(5);
    
    public StorageChief(){} // Constructor

	public void storageFurniture(ProductionLine<T> productionLine){ // takes front element from the queue, pushes it to related warehouse (stack).
		if(!productionLine.isEmpty()) {	
			T product = productionLine.dequeue();
	        if( ((IProduct)product).getName() == "Sofa" ){
	            sofaWarehouse.push(product);
	            System.out.println("Storage Chief storing "+((IProduct)product).getName()+", SUCCESS, "+((IProduct)product).getName()+" in "+((IProduct)product).getName()+" warehouse");
	        }
	        else if( ((IProduct)product).getName() == "Bed" ){
	            bedWarehouse.push(product);
	            System.out.println("Storage Chief storing "+((IProduct)product).getName()+", SUCCESS, "+((IProduct)product).getName()+" in "+((IProduct)product).getName()+" warehouse");
	        }
	        else if( ((IProduct)product).getName() == "Chair" ){
	            chairWarehouse.push(product);
	            System.out.println("Storage Chief storing "+((IProduct)product).getName()+", SUCCESS, "+((IProduct)product).getName()+" in "+((IProduct)product).getName()+" warehouse");
	        }
	        else if( ((IProduct)product).getName() == "Dresser" ){
	            dresserWarehouse.push(product);
	            System.out.println("Storage Chief storing "+((IProduct)product).getName()+", SUCCESS, "+((IProduct)product).getName()+" in "+((IProduct)product).getName()+" warehouse");
	        }
	        else if( ((IProduct)product).getName() == "Table" ){
	            tableWarehouse.push(product);
	            System.out.println("Storage Chief storing "+((IProduct)product).getName()+", SUCCESS, "+((IProduct)product).getName()+" in "+((IProduct)product).getName()+" warehouse");
	        }
	        else if( ((IProduct)product).getName() == "Bookcase" ){
	            bookcaseWarehouse.push(product);
	            System.out.println("Storage Chief storing "+((IProduct)product).getName()+", SUCCESS, "+((IProduct)product).getName()+" in "+((IProduct)product).getName()+" warehouse");
	        }
		}
		else {
			System.out.println("Storage Chief storing nothing because Production Line is empty.");
		}
	}
	
	// Helper function to found array length without NULL elements.
	public static <T> int getLength(T[] arr) {
	    int count = 0;
	    for(T el : arr)
	        if (el != null)
	            ++count;
	    return count;
	}
	
	// gives report of how many furniture exist in warehouses after simulation
	public void warehouseReport() {
		int bedNo = 0;
		int sofaNo = 0;
		int dresserNo = 0;
		int tableNo = 0;
		int chairNo = 0;
		int bookcaseNo = 0;
		    
		bedNo = getLength(bedWarehouse.getStack());
		sofaNo = getLength(sofaWarehouse.getStack());
		dresserNo = getLength(dresserWarehouse.getStack());
		tableNo = getLength(tableWarehouse.getStack());
		chairNo = getLength(chairWarehouse.getStack());
		bookcaseNo = getLength(bookcaseWarehouse.getStack());

		System.out.println("Amount of Bed in Bed Warehouse:" +bedNo); 
		System.out.println("Amount of Sofa in Sofa Warehouse:" +sofaNo);  
		System.out.println("Amount of Dresser in Dresser Warehouse: " +dresserNo);  
		System.out.println("Amount of Table in Table Warehouse: " +tableNo);  
		System.out.println("Amount of Chair in Chair Warehouse: " +chairNo);  
		System.out.println("Amount of Bookcase in Bookcase Warehouse: " +bookcaseNo +"\n");  
	}
}


