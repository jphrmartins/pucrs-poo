package app;

import entities.Product;
import entities.Sale;
import entities.SalesBase;
import entities.Stock;

import java.util.List;
import java.util.Map;

public interface SystemDatabase {
    Map<String, Product> getStock();
    Map<Integer, Sale> getSalesBase();
    void updateStockItems(Map<String, Product> products);

}
