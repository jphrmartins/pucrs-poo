package infra;

import entities.product.sale.SalesBase;
import entities.product.stock.Stock;

public interface SystemLoader {
    Stock getStock();
    SalesBase getSalesBase();
}
