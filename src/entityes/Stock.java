package entityes;

import java.util.ArrayList;

public class Stock {

    ArrayList<Product> listOfProducts;

    public Stock() {
        this.listOfProducts = new ArrayList<>();
    }

    public Product getProduct(int barCode) {
        for (Product product : listOfProducts)
            if (product.getBarCode() == barCode)
                return product;
        System.out.println("entityes.Product not found in stock");
        return null;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }


}