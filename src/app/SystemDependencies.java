package app;

import entities.SalesBase;
import entities.Stock;

public class SystemDependencies {
    private Stock stock;
    private SalesBase salesBase;

    public SystemDependencies(Stock stock, SalesBase salesBase) {
        this.stock = stock;
        this.salesBase = salesBase;
    }

    public Stock getStock() {
        return stock;
    }

    public SalesBase getSalesBase() {
        return salesBase;
    }
}
