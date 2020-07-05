package entities;

import java.util.List;

public class Receipt {
    private int id;
    private double totalPrice;
    private double discount;
    private double tax;
    private double total;
    List<Product> list;

    public Receipt(int id, double totalPrice, double discount, double tax, double total, List<Product> list) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder values;
        values = new StringBuilder("Recibo de venda número: " + this.id + "\n");
        values.append("Numero do item | Código | Descricão | Preço unitário | Quantidade | Valor do item \n");
        for (int i = 0; i < list.size(); i++) {
            values.append(i + 1).append(" | ")
                    .append(list.get(i).getBarCode()).append(" | ")
                    .append(list.get(i).getDescription()).append(" | ")
                    .append(list.get(i).getPrice()).append(" | ")
                    .append(list.get(i).getAmount()).append(" | ")
                    .append((list.get(i).getAmount()) * (list.get(i).getPrice())).append("\n");
        }
        values.append("               Total | ").append(this.totalPrice).append("\n")
                .append("                  Desconto | ").append(this.discount).append("\n")
                .append("                  Imposto | ").append(this.tax).append("\n")
                .append("           Valor da venda  | ").append(this.total);
        return values.toString();
    }
}
