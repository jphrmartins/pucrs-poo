package entityes;

public abstract class Product {

    private String description;
    private double price;
    private int amount;
    private final int barCode;

    protected Product(String description, double price, int amount, int barCode) {
        this.description = description;
        this.price = price;
        this.barCode = barCode;
        this.amount = amount;
    }

    public int getBarCode() {
        return this.barCode;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
}