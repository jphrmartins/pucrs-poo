package entities;

public class saleItem extends Product {

    private int amount;

    public saleItem(String description, double price, String barCode, int amount) {
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
