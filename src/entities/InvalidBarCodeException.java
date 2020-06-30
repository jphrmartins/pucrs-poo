package entities;

public class InvalidBarCodeException extends RuntimeException {
    public InvalidBarCodeException(String messege) {
        super(messege);
    }
}
