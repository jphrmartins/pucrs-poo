package entities.product.sale;

import java.util.Map;

public class SalesBase {

    private Map<Integer, Sale> sales;

    public SalesBase(Map<Integer, Sale> sales) {
        this.sales = sales;
    }

    Sale getSale(int saleId) {
        return sales.get(saleId);
    }

    public Map<Integer, Sale> getSales() {
        return sales;
    }
}
