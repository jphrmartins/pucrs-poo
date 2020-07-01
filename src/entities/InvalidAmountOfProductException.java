package entities;

public class InvalidAmountOfProductException extends IllegalStateException {
    public InvalidAmountOfProductException(int amount) {
        super("Quantidade do produto inválida, a quntidade maxima encontrada é de " + amount);
    }
}
