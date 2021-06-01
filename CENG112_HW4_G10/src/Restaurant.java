public class Restaurant { 
    private String name;
    private double rating;
    private String cuisine;
    private int deliveryTime;// in minutes

    public Restaurant(String name,double rating,String cuisine,int deliveryTime){
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;
        this.deliveryTime = deliveryTime;

    }
    
    public void updateCuisine(String category){};
    public void updateRating(double score){};
    public void updateDeliveryTime(int deliveryTime){};
     // Constructors, getters, setters and other methods
    }
    