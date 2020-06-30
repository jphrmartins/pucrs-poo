package entities;

import entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {

    private Map<String, Product> listOfProducts;

    public Stock() {
        this.listOfProducts = new HashMap<String, Product>();
    }

    public Product getProduct(String barCode) {
        return this.listOfProducts.get(barCode);
    }



    public Map<String, Product> getListOfProducts() {
        return this.listOfProducts;
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(this.listOfProducts.values());
    }
    
    public void addProduct(Product stockItem){
        this.listOfProducts.put(stockItem.getBarCode(), stockItem);
    }
}
