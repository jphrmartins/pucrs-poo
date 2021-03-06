package entities;


import app.SystemDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stock {

    private final SystemDatabase database;
    private final Map<String, Product> listOfProducts;

    public Stock(SystemDatabase systemDatabase, Map<String, Product> listOfProducts) {
        this.database = systemDatabase;
        this.listOfProducts = listOfProducts;
    }

    public boolean hasProduct(String barCode) {
        return listOfProducts.containsKey(barCode);
    }

    public Product getProduct(String barCode) {
        return this.listOfProducts.get(barCode);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(this.listOfProducts.values());
    }

    public void addProduct(Product stockItem) {
        this.listOfProducts.put(stockItem.getBarCode(), stockItem);
        database.updateStockItems(listOfProducts);
    }

    public void stockAdjust(String barCode, int amount) {
        this.listOfProducts.get(barCode).setAmount(this.listOfProducts.get(barCode).getAmount() + amount);
        database.updateStockItems(listOfProducts);
    }

    public void updateForCancelSale(Sale sale) {
        sale.getItems().stream()
                .map(Product::duplicate)
                .forEach(productToUpdate -> {
                    Product product = this.listOfProducts.get(productToUpdate.getBarCode());
                    if (product != null) {
                        product.setAmount(product.getAmount() + productToUpdate.getAmount());
                    } else {
                        this.listOfProducts.put(productToUpdate.getBarCode(), productToUpdate);
                    }
                });
        database.updateStockItems(listOfProducts);
    }

    public void decrement(String barCode) {
        Product product = this.listOfProducts.get(barCode);
        product.setAmount(product.getAmount() - 1);
        database.updateStockItems(listOfProducts);
    }
}
