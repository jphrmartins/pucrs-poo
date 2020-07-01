package entities;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String barCode) {
        super("Produto com o código " + barCode + " não encontrado");
    }
}
