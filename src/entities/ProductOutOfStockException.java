package entities;

public class ProductOutOfStockException extends IllegalStateException {
    public ProductOutOfStockException(Product product) {
        super("Produto " + product.getBarCode() + " não possui mais itens no estoque.");
    }
}
