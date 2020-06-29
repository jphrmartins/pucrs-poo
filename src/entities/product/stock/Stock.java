package entities.product.stock;

import entities.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Stock {

    private Map<String, StockItem> listOfProducts;

    public Stock() {
        this.listOfProducts = new HashMap<String, StockItem>();
    }

    public StockItem getProduct(String barCode) {
        return this.listOfProducts.get(barCode);
    }

    public Map<String, StockItem> getListOfProducts() {
        return this.listOfProducts;
    }

    public void listenProducts(){
        for (Product product: this.listOfProducts.values()) {
            System.out.println(product.getDescription());
        }
    }
    
    public void addProduct(StockItem stockItem){
        this.listOfProducts.put(stockItem.getBarCode(), stockItem);
    }
}
