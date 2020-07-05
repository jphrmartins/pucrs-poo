package app;

import entities.Product;
import entities.Sale;
import entities.SalesBase;
import entities.Stock;

import java.util.List;
import java.util.Map;

public interface SystemDatabase {
    SystemDependencies loadSystem();
    void updateStockItems(Map<String, Product> products);
    void updateSalesBase(Map<Integer, Sale> sales);
}
