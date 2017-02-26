package example.codeclan.com.java_comic_shop;

/**
 * Created by user on 24/02/2017.
 */
public class StockItem {

    private String name;
    private double price;




    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
