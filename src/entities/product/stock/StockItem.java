package entities.product.stock;

import entities.product.Product;

public class StockItem extends Product {

    private int amount;

    public StockItem(String description, double price, String barCode, int amount) {
        super(description, price, barCode);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
