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
        this.itens.add(product);
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

}
