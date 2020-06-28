package entities;

import java.util.HashMap;
import java.util.Map;

public class Stock {

    private Map<String, stockItem> listOfProducts;

    public Stock() {
        this.listOfProducts = new HashMap<String, stockItem>();
    }

    public stockItem getProduct(String barCode) {
        return this.listOfProducts.get(barCode);
    }

    public Map getListOfProducts() {
        return this.listOfProducts;
    }
    
    public void addProduct(stockItem stockItem){
        this.listOfProducts.put(stockItem.getBarCode(), stockItem);
    }

    public boolean removeProduct(String barCode){
        // TODO: 22/06/2020
        return true;
    }

}