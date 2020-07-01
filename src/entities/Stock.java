package entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {

    private Map<String, Product> listOfProducts;

    public Stock() {
        this.listOfProducts = new HashMap<String, Product>();
    }

    public Product findProduct(String barCode){
        for (Product product : this.listOfProducts.values()) {
            if (product.getBarCode().equals(barCode)) return product;
        }
        return null;
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
}
