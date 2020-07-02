package entities;

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
        return this.price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Descrição = '" + description + '\'' +
                ", Preço = " + price +
                ", Codigo de Barras = '" + barCode + '\'' +
                ", Quantidade Disponível em Estoque = " + amount +
                '}';
    }
}