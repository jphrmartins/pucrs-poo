package entityes;

import java.util.Map;

public class Stock {

    private Map<String, Product> listOfProducts;

    public Stock() {
        this.listOfProducts = new HashMap<String, Product>();
    }

    public Product getProduct(String barCode) {
        return this.listOfProducts.get(barCode);
    }

    public Map getListOfProducts() {
        return this.listOfProducts;
    }
    
    public void addProduct(Product product){
        this.listOfProducts.put(product.getBarCode(), product);
    }

    public boolean removeProduct(String barCode){
        // TODO: 22/06/2020
        return true;
    }

}