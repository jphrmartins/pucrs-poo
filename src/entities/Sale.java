package entities;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private static int ACTUAL_ID = 1;
    private int id;
    private SaleStatus status;
    private List<Product> itens;

    public Sale() {
        this.id = ACTUAL_ID++;
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addItem(Product product) {
        Product productInList = findProduct(product.getBarCode());
        if (productInList != null) productInList.setAmount(productInList.getAmount() + 1);
        else this.itens.add(product);
    }

    public Product findProduct(String barCode) {
        return itens.stream()
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

    public List<Product> getItens() {
        return itens;
    }

    public void removeItem(Product product) {
        itens.remove(product);
    }
}
