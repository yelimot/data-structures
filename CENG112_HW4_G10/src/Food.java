public class Food {
    private String name;
    private double price;
    private int stock;
    private Restaurant restaurant;
// Constructors, getters, setters and other methods {

    public Food(String name,double price,Restaurant restaurant,int stock){
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
        this.stock = stock;

    }
    
}
