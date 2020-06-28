package entities.product.sale;

import entities.product.Product;

public class SaleItem extends Product {

    private int amount;

    public SaleItem(String description, double price, String barCode, int amount) {
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
