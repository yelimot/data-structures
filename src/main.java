import java.util.Random;

public class main {
    public static void main(String[] args){

        Product productSofa = new Product("Sofa",1);
        Product productBed = new Product("Bed",2);
        Product productChair = new Product("Chair",3);
        Product productDresser = new Product("Dresser",4);
        Product productTable = new Product("Table",5);
        Product productBookcase = new Product("Bookcase",6);

        Product arrayOfProduct[] = new Product[6];

        arrayOfProduct[0] = productSofa;
        arrayOfProduct[1] = productBed;
        arrayOfProduct[2] = productChair;
        arrayOfProduct[3] = productDresser;
        arrayOfProduct[4] = productTable;
        arrayOfProduct[5] = productBookcase;

        Random rand = new Random();
        MarketingAnalyst marketingAnalyst = new MarketingAnalyst();
        StorageChief storageChief = new StorageChief<>();

        int numberOfActivities = rand.nextInt(3); // generates 0-1-2
        int numberOfProduct = rand.nextInt(6); // generates 0-1-2-3-4-5
        
        numberOfActivities = 1;
        System.out.println("Random Integers: "+numberOfActivities);
        System.out.println("Random Integers: "+numberOfProduct);

        if(numberOfActivities == 0){ // Market Analyst
            marketingAnalyst.manufactureFurniture(arrayOfProduct[numberOfProduct]);

        }
        else if(numberOfActivities == 1){ // Storage Chief
            storageChief.storageFurniture(arrayOfProduct[numberOfProduct]);
         
        }
        else if(numberOfActivities == 2){ // Customer
            System.out.println("");
        }
    
    
}
}

