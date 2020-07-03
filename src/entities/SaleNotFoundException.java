package entities;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException(int saleId) {
        super("Venda " + saleId + ", não econtrada");
    }
}
