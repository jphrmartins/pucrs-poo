package business;

import entities.*;

import java.util.*;
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
        return new MenuRange(1, 5);
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
                getTopFiveSalesProducts();
                break;
            case 4:
                saleBase.getAllSales().stream()
                        .filter(it -> it.getStatus() == SaleStatus.CANCELED)
                        .forEach(System.out::println);
                break;
        }
    }

    private void getTopFiveSalesProducts() {
        List<Product> productsToProcess = new ArrayList<>();
        saleBase.getAllSales().stream()
                .filter(it -> it.getStatus() == SaleStatus.FINISHED)
                .forEach(it -> productsToProcess.addAll(it.getItems()));
        if (productsToProcess.isEmpty()) {
            System.out.println("Impossível analisar itens mais vendidos pois não existem vendas finalizadas");
        } else {
            List<Product> orderedProducts = productsToProcess.stream()
                    .collect(Collectors.groupingBy(Product::getBarCode, Collectors.reducing((first, last) -> new Product(
                            first.getDescription(),
                            first.getPrice(),
                            first.getBarCode(), first.getAmount() + last.getAmount())))
                    ).values()
                    .stream()
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .sorted((first, last) -> last.getAmount().compareTo(first.getAmount()))
                    .collect(Collectors.toList());
            System.out.println("Top 5 itens vendidos ");

        for (int i = 0; i < orderedProducts.size() && i < 5; i++) {
                System.out.println(orderedProducts.get(i));
            }
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
            System.out.println("Média do faturamento total: " + round(total / receipts.size()));
        } else System.out.println("Imposivel calcular média do faturamento total pois não existe vendas fechadas");
    }

    private void calculateTotalBilled() {
        double totalGrossValue = 0;
        double totalNetValue = 0;
        List<Receipt> receipts = saleBase.getAllSales().stream()
                .filter(it -> it.getStatus() == SaleStatus.FINISHED)
                .map(Sale::generateReceipt)
                .collect(Collectors.toList());
        if (receipts.isEmpty()) {
            System.out.println("Impossível analisar itens mais vendidos pois não existem vendas finalizadas");
        } else {
            for (Receipt receipt : receipts) {
                totalGrossValue += receipt.getTotal();
                totalNetValue += receipt.getTotal() - receipt.getTax();
            }
            System.out.println("Total faturado bruto: " + totalGrossValue);
            System.out.println("Total faturado liquido: " + totalNetValue);
        }
    }

    private double round(double price) {
        double roundedPrice = price * 100;
        roundedPrice = Math.ceil(roundedPrice);
        return roundedPrice / 100;
    }
}
