
public class MarketingAnalyst<T> {
	
    public ProductionLine<T> productionLine = new ProductionLine<T>(10); // creates productLine for marketing analyst
	
	public MarketingAnalyst(){} // constructor

    public void manufactureFurniture(T product){ // manufacture function
    	productionLine.enqueue(product); // adds product to the queue
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

		for(int i = 0 ;i<productionLine.getQueue().length; i++){
			if(((IProduct)productionLine.getQueue()[i]) ==  null){
				continue;
			}
			else if(((IProduct)productionLine.getQueue()[i]).getName() == "Bed") {
				bedNo++;
			}
			else if(((IProduct)productionLine.getQueue()[i]).getName() == "Sofa") {
				sofaNo++;
			}
			else if(((IProduct)productionLine.getQueue()[i]).getName() == "Dresser") {
				dresserNo++;
			}
			else if(((IProduct)productionLine.getQueue()[i]).getName() == "Table") {
				tableNo++;
			}
			else if(((IProduct)productionLine.getQueue()[i]).getName() == "Chair") {
				chairNo++;
			}
			else if(((IProduct)productionLine.getQueue()[i]).getName() == "Bookcase") {
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
