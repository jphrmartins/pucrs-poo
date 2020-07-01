package entities;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private int id;
    private SaleStatus status;
    private List<Product> itens;

    public Sale(int id) {
        this.id = id;
        this.status = SaleStatus.ACTIVE;
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addItem(Product product) {
        this.itens.add(product);
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public List<Product> getItens() {
        return itens;
    }

    public void setItems(List<Product> itens) {
        this.itens = itens;
    }
}
