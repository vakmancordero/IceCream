package icecream.beans;

/**
 *
 * @author Arturh
 */
public class IceCream {
    
    private String flavor;
    private String size;
    private double price;
    private String decoration;

    public IceCream() {
        
    }
    
    public IceCream(String flavor, String size, double price, String decoration) {
        this.flavor = flavor;
        this.size = size;
        this.price = price;
        this.decoration = decoration;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    @Override
    public String toString() {
        return this.price + " - " + this.flavor + " - " + this.decoration;
    }
    
}