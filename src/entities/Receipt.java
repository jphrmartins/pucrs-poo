package entities;

import java.util.List;

public class Receipt {
    private int id;
    private double totalPrice;
    private double discount;
    private double tax;
    private double total;
    private List<Product> list;

    public Receipt(int id, double totalPrice, double discount, double tax, double total, List<Product> list) {
        this.id = id;
        this.totalPrice = round(totalPrice);
        this.discount = discount;
        this.tax = round(tax);
        this.total = round(total);
        this.list = list;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder("=====================================\n");
        stringBuilder.append("Recibo de venda número: ").append(this.id).append("\n");
        stringBuilder.append("Numero do item | Código | Descricão | Preço unitário | Quantidade | Valor do item \n");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1).append(" | ")
                    .append(list.get(i).getBarCode()).append(" | ")
                    .append(list.get(i).getDescription()).append(" | ")
                    .append(list.get(i).getPrice()).append(" | ")
                    .append(list.get(i).getAmount()).append(" | ")
                    .append((round(list.get(i).getAmount() * list.get(i).getPrice()))).append("\n");
        }
        stringBuilder.append("\t\t\t\tTotal | ").append(this.totalPrice).append("\n")
                    .append("\t\t\t\tDesconto | ").append(this.discount).append("\n")
                    .append("\t\t\t\tImposto | ").append(this.tax).append("\n")
                .append("\t\t\t\tValor da venda  | ").append(this.total);
        stringBuilder.append("\n=====================================\n");
        return stringBuilder.toString();
    }

    private double round(double price) {
        double roundedPrice = price * 100;
        roundedPrice = Math.ceil(roundedPrice);
        return roundedPrice / 100;
    }
}
