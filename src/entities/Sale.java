package entities;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private static int ACTUAL_ID = 1;
    private int id;
    private SaleStatus status;
    private List<Product> items;

    public Sale() {
        this.id = ACTUAL_ID++;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addItem(Product product) {
        Product productInList = findProduct(product.getBarCode());
        if (productInList != null) productInList.setAmount(productInList.getAmount() + 1);
        else this.items.add(product);
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

    public double getTotalPrice(){
        return items.stream()
                .mapToDouble(it -> it.getAmount() * it.getPrice())
                .sum();
    }
}
