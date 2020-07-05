package business;

import entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class ReportBaseMenu implements BaseMenuOperator {

    private SalesBase saleBase;

    public ReportBaseMenu(SalesBase saleBase) {
        this.saleBase = saleBase;
    }

    @Override
    public String getMenuText() {
        return "1 - Faturamento atual\n" +
                "2 - Ticket médio de vendas\n" +
                "3 - Produtos mais vendidos\n" +
                "4 - Listar vendas canceladas\n" +
                "5 - Sair";
    }

    @Override
    public MenuRange getMenuRange() {
        return new MenuRange(1,5);
    }

    @Override
    public MenuType getMenuType() {
        return MenuType.REPORTS;
    }

    @Override
    public void operate(int option) {
        switch (option) {
            case 1:
                calculateTotalBilled();
                break;
            case 2:
                calculateAverageValue();
                break;
            case 3:

                break;
            case 4:
                saleBase.getAllSales().stream()
                        .filter(it -> it.getStatus() == SaleStatus.CANCELED)
                        .forEach(System.out::println);
                break;
        }
    }

    private void calculateAverageValue() {
        double total = 0;
        List<Receipt> receipts = saleBase.getAllSales().stream()
                .filter(it -> it.getStatus() == SaleStatus.FINISHED)
                .map(Sale::generateReceipt)
                .collect(Collectors.toList());
        if (!receipts.isEmpty()) {
            for (Receipt receipt : receipts) {
                total += receipt.getTotal();
            }
            System.out.println("Média do faturamento total: " + total/receipts.size());
        } else System.out.println("Imposivel calcular média do faturamento total pois não existe vendas fechadas");
    }

    private void calculateTotalBilled() {
        double totalGrossValue = 0;
        double totalNetValue = 0;
        List<Receipt> receipts = saleBase.getAllSales().stream()
                .map(Sale::generateReceipt)
                .collect(Collectors.toList());
        for (Receipt receipt : receipts) {
            totalGrossValue += receipt.getTotal();
            totalNetValue += receipt.getTotal() - receipt.getTax();
        }
        System.out.println("Total faturado bruto: " + totalGrossValue);
        System.out.println("Total faturado liquido: " + totalNetValue);
    }
}
