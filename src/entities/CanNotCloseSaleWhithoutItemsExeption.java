package entities;

public class CanNotCloseSaleWhithoutItemsExeption extends IllegalStateException {
    public CanNotCloseSaleWhithoutItemsExeption() {
        super("Impossivel finalizar venda sem nenhum item");
    }
}
