package entities;

import app.SystemDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesBase {

    private final SystemDatabase systemDatabase;
    private final Map<Integer, Sale> sales;

    public SalesBase(SystemDatabase systemDatabase, Map<Integer, Sale> sales) {
        this.systemDatabase = systemDatabase;
        this.sales = sales;
    }

    public void addSale(Sale sale) {
        this.sales.put(sale.getId(), sale);
        systemDatabase.updateSalesBase(this.sales);
    }

    public List<Sale> getAllSales() {
        return new ArrayList<>(sales.values());
    }

    public Sale find(int saleId) {
        Sale sale = sales.get(saleId);
        if (sale != null) return sale;
        throw new SaleNotFoundException(saleId);
    }

    public void cancelSale(Sale saleToCancel) {
        Sale sale = sales.get(saleToCancel.getId());
        sale.cancel();
        systemDatabase.updateSalesBase(sales);
    }
}
