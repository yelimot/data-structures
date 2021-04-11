
public class MarketingAnalyst<T> {
	
    public ProductionLine<T> productLine = new ProductionLine<T>(10); // creates productLine for marketing analyst
	
	public MarketingAnalyst(){} // constructor

    public void manufactureFurniture(T product){ // manufacture function
        productLine.enqueue(product); // adds product to the queue
        System.out.println("MarketingAnalyst requesting "+((IProduct) product).getName()+", SUCCESS, "+
        ((IProduct)product).getName()+" manufactured");
    }

    public void factoryLineReport(){ // gives report of how many furniture exist in the factory line after simulation
		int bedNo = 0;
		int sofaNo = 0;
		int dresserNo = 0;
		int tableNo = 0;
		int chairNo = 0;
		int bookcaseNo = 0;

		for(int i = 0 ;i<productLine.getQueue().length; i++){
			if(((IProduct)productLine.getQueue()[i]) ==  null){
				continue;
			}
			else if(((IProduct)productLine.getQueue()[i]).getName().equals("Bed")) {
				bedNo++;
			}
			else if(((IProduct)productLine.getQueue()[i]).getName().equals("Sofa")) {
				sofaNo++;
			}
			else if(((IProduct)productLine.getQueue()[i]).getName().equals("Dresser")) {
				dresserNo++;
			}
			else if(((IProduct)productLine.getQueue()[i]).getName().equals("Table")) {
				tableNo++;
			}
			else if(((IProduct)productLine.getQueue()[i]).getName().equals("Chair")) {
				chairNo++;
			}
			else if(((IProduct)productLine.getQueue()[i]).getName().equals("Bookcase")) {
				bookcaseNo++;
			}
		}
	
        System.out.println("\n" + "Amount of Bed in Factory Line: " + bedNo); 
		System.out.println("Amount of Sofa in Factory Line: " + sofaNo);  
		System.out.println("Amount of Dresser in Factory Line: " + dresserNo);  
		System.out.println("Amount of Table in Factory Line: " + tableNo);  
		System.out.println("Amount of Chair in Factory Line: " + chairNo);  
		System.out.println("Amount of Bookcase in Factory Line: " + bookcaseNo+"\n"); 
    }	
}	
