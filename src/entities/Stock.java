package entities;


import app.SystemDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {

    private final SystemDatabase database;
    private final Map<String, Product> listOfProducts;

    public Stock(SystemDatabase systemDatabase) {
        this.database = systemDatabase;
        this.listOfProducts = database.getStock();
    }

    public boolean hasProduct(String barCode){
        return this.listOfProducts.containsKey(barCode);
    }

    public Product getProduct(String barCode) {
        return this.listOfProducts.get(barCode);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(this.listOfProducts.values());
    }

    public void addProduct(Product stockItem) {
        this.listOfProducts.put(stockItem.getBarCode(), stockItem);
    }

    public void stockAdjust(String barCode, int amount) {
        this.listOfProducts.get(barCode).setAmount(this.listOfProducts.get(barCode).getAmount() + amount);
    }

    public void updateForCancelSale(Sale sale) {
        sale.getItems().stream()
                .map(Product::duplicate)
                .forEach(this::updateStock);
        database.updateStockItems(listOfProducts);
    }

    private void updateStock(Product product) {
        HashMap<String, Object> a;
        this.listOfProducts.get(product.getBarCode())
    }
}
