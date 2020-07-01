package entities;

import entities.Sale;

import java.util.ArrayList;
import java.util.List;
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

    public List<Sale> getAllSales() {
        return new ArrayList<>(sales.values());
    }
}
