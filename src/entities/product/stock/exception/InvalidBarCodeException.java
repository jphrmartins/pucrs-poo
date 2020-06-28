package entities.product.stock.exception;

public class InvalidBarCodeException extends RuntimeException {
    public InvalidBarCodeException(String messege) {
        super(messege);
    }
}
