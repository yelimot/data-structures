public class StorageChief<T>{

    public StorageChief(){}

    Warehouse<T> sofaWarehouse = new Warehouse<>(5);
    Warehouse<T> bedWarehouse = new Warehouse<>(5);
    Warehouse<T> chairWarehouse = new Warehouse<>(5);
    Warehouse<T> dresserWarehouse = new Warehouse<>(5);
    Warehouse<T> tableWarehouse = new Warehouse<>(5);
    Warehouse<T> bookcaseWarehouse = new Warehouse<>(5);

    public void storageFurniture(T product){
        if( ((Product)product).getName() == "Sofa" ){
            // Ödev slaytında göremedim fakat MarketAnaliystinde yoksa eğer buraya yerleşmeyecek onun check'i atılacak.
            sofaWarehouse.push(product);

        }
        else if( ((Product)product).getName() == "Bed" ){
            bedWarehouse.push(product);

        }
        else if( ((Product)product).getName() == "Chair" ){
            chairWarehouse.push(product);

        }
        else if( ((Product)product).getName() == "Dresser" ){
            dresserWarehouse.push(product);

        }
        else if( ((Product)product).getName() == "Table" ){
            tableWarehouse.push(product);

        }
        else if( ((Product)product).getName() == "Bookcase" ){
            bookcaseWarehouse.push(product);

        }


    }
}