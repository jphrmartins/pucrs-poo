package entities;

import java.util.List;

public class Receipt {
    private int id;
    private double totalPrice;
    private double discount;
    private double tax;
    private double total;
    List<Product> list;

    public Receipt(int id, double totalPrice, double discount, double tax, double total, List<Product> list) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
        this.list = list;
    }

}
