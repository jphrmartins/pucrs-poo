package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sale {

    private static int ACTUAL_ID = 1;
    private int id;
    private SaleStatus status;
    private double discountPercent;
    private List<Product> items;

    public Sale(int id, SaleStatus status, double discountPercent, List<Product> items) {
        this.id = id;
        ACTUAL_ID = id;
        this.status = status;
        this.discountPercent = discountPercent;
        this.items = items;
    }

    public Sale() {
        this.id = ACTUAL_ID++;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addItem(Product product) {
        try {
            Product productInList = findProduct(product.getBarCode());
            productInList.setAmount(productInList.getAmount() + 1);
        } catch (ProductNotFoundException ex) {
            this.items.add(product);
        }
    }

    public Product findProduct(String barCode) {
        return items.stream()
                .filter(it -> it.getBarCode().equals(barCode))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(barCode));
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void cancel() {
        this.status = SaleStatus.CANCELED;
    }

    public void finish() {
        this.status = SaleStatus.FINISHED;
    }

    public List<Product> getItems() {
        return items;
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(it -> it.getAmount() * it.getPrice())
                .sum();
    }

    public Receipt generateReceipt() {
        double totalPrice = getTotalPrice();
        double discount = (totalPrice * discountPercent) / 100;
        totalPrice = totalPrice - discount;
        double tax = totalPrice * 0.25;
        totalPrice = totalPrice + tax;

        return new Receipt(getId(), getTotalPrice(), discount, tax, totalPrice, getItems());
    }

    @Override
    public String toString() {
        String items = this.items.stream().map(Product::toString).collect(Collectors.joining(", "));
        return "Venda{" +
                "id = " + id +
                ", status = " + status.getNamedStatus() +
                ", percentual de desconto = " + discountPercent +
                ", itens = [" + items + "]" +
                '}';
    }
}
