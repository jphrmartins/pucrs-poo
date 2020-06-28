package entities.product;

import entities.product.stock.exception.InvalidBarCodeException;

import java.util.regex.Pattern;

public abstract class Product {

    private String description;
    private double price;
    private final String barCode;

    public Product(String description, double price, String barCode) {
        this.description = description;
        this.price = price;
        if(Pattern.matches("`[0-9]+$", barCode)){
            this.barCode = barCode;
        }else{
            throw new InvalidBarCodeException("Codigo de barra deve serguir o padão de somente numeros.");
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