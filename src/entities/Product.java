package entities;

import java.util.stream.Stream;

public class Product {

    private String description;
    private double price;
    private final String barCode;
    private int amount;


    public Product(String description, double price, String barCode, int amount) {
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.barCode = barCode;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return round(this.price);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public Product duplicate()  {
        return new Product(this.description, this.price, this.barCode, this.amount);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Descrição = '" + description + '\'' +
                ", Preço = " + round(price) +
                ", Codigo de Barras = '" + barCode + '\'' +
                ", Quantidade = " + amount +
                '}';
    }

    private double round(double price) {
        double priceToRound = price * 100;
        priceToRound = Math.ceil(priceToRound);
        return priceToRound / 100;
    }
}