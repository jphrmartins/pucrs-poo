package entities.product.sale;

import java.util.Map;

public class SalesBase {

    private Map<Integer, Sale> sales;

    public SalesBase(Map<Integer, Sale> sales) {
        this.sales = sales;
    }


}
