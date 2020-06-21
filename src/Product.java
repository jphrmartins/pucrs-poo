public abstract class Product {

    private String description;
    private double price;
    private final String code;

    protected Product(String description, double price, String code) {
        this.description = description;
        this.price = price;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
}