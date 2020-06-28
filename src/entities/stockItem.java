package entities;

public class stockItem extends Product{

    private int amount;

    public stockItem(String description, double price, String barCode, int amount) {
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
