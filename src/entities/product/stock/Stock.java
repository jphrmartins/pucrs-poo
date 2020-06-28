package entities.product.stock;

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
    
    public void addProduct(StockItem stockItem){
        this.listOfProducts.put(stockItem.getBarCode(), stockItem);
    }

}