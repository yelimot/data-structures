
public class MarketingAnalyst<T> {

    public MarketingAnalyst(){}

    ProductionLine<T> productionLine = new ProductionLine<T>(10);

    public void manufactureFurniture(T product){
        productionLine.enqueue(product);
        System.out.println("MarketingAnalyst requesting "+((Product)product).getName()+", SUCCES, "+
        ((Product)product).getName()+" manufactured");
    }

    public void giveReport(){
        for(int i = 0 ; i< productionLine.queue.length ; i++){
            System.out.println("Amount of "+ ((Product)productionLine.queue[0]).getName() + "in Factory Line" +((Product)productionLine.queue[0]).getProductNo());

        }

    }
	
}	
