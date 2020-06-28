package entities.product;

import java.util.regex.Pattern;

public abstract class Product {

    private String description;
    private double price;
    private final String barCode;

    public Product(String description, double price, String barCode) {
        this.description = description;
        this.price = price;
        if(Pattern.matches("[]0-9]", barCode) == true){
            this.barCode = barCode;
        }else{
            this.barCode = "XXXXX"; // TODO: 22/06/2020
        }
    }

    public String getBarCode() {
        return this.barCode;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
}