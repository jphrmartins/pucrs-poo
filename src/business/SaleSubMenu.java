package business;

import app.SystemDependencies;
import entities.*;

import java.util.Scanner;
import java.util.regex.Pattern;

import static business.ReaderHelper.*;

public class SaleSubMenu implements SubMenuOperator {

    private Scanner scanner;
    private Stock stock;
    private SalesBase salesBase;
    private Sale sale;

    public SaleSubMenu(Scanner scanner, SystemDependencies systemDependencies) {
        this.scanner = scanner;
        this.stock = systemDependencies.getStock();
        this.salesBase = systemDependencies.getSalesBase();
        this.sale = new Sale();
    }

    @Override
    public void operate() {
        System.out.println("===============");
        int option;
        do {
            showMenu();
            option = readOption();
            switch (option) {
                case 1:
                    try {
                        addItem();
                    } catch (ProductNotFoundException | ProductOutOfStockException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    sale.getItems().forEach(System.out::println);
                    break;
                case 4:
                    try {
                        Receipt receipt = endSale();
                        System.out.println("Recibo");
                        System.out.println(receipt);
                    } catch (CanNotCloseSaleWhithoutItemsExeption ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 5:
                    stock.updateForCancelSale(sale);
                    break;
            }
            if (sale.getStatus() == SaleStatus.FINISHED) break;
        } while (option >= 1 && option < 5);
    }

    private Receipt endSale() {
        if (sale.getItems().isEmpty()) throw new CanNotCloseSaleWhithoutItemsExeption();
        else {
            if (sale.getTotalPrice() >= 250) applyDiscount();
            sale.finish();
            Receipt receipt = sale.generateReceipt();
            salesBase.addSale(sale);
            return receipt;
        }
    }

    private void applyDiscount() {
        System.out.println("Deseja aplicar desconto S | N ?");
        String option = scanner.next();
        if (option.equalsIgnoreCase("s")) {
            double discount = askDiscount();
            sale.setDiscountPercent(discount);
        }
    }

    private double askDiscount() {
        System.out.println("Qual o percentual de desconto que deseja aplicar ?");
        double discount;
        do {
            System.out.println("Valores permitidos estão dentro do conjunto 1% e 10%");
            discount = readDouble(scanner);
        } while ((discount < 1 || discount > 10));
        return discount;
    }

    private void removeItem() {
        if (sale.getItems().isEmpty()) {
            System.out.println("Venda não possui nenhum intem, por favor, insira um item");
        } else {
            try {
                tryRemoveItem();
            } catch (ProductNotFoundException | InvalidAmountOfProductException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void tryRemoveItem() {
        System.out.println("Por favor, informe o codigo de barra do item que deseja tirar");
        Product product = sale.findProduct(readBarCode(scanner));
        System.out.println("Qual a quantidade que deseja ser removida");
        int amount = readInteger(scanner);
        if (product.getAmount() < amount) throw new InvalidAmountOfProductException(product.getAmount());
        else if (product.getAmount() == amount) sale.removeItem(product);
        else product.setAmount(product.getAmount() - amount);
        stock.stockAdjust(product.getBarCode(), amount);
    }


    private void addItem() {
        String barCode;
        do {
            System.out.println("Entre com o código de barras ou 'S' para sair");
            barCode = scanner.nextLine();
            if (barCode.equalsIgnoreCase("s")) break;
            if (Pattern.matches("^[0-9]+$", barCode)) {
                Product product = stock.getProduct(barCode);
                if (product != null) {
                    if (product.getAmount() == 0) throw new ProductOutOfStockException(product);
                    stock.decrement(product.getBarCode());
                    Product item = product.duplicate();
                    item.setAmount(1);
                    sale.addItem(item);
                    System.out.println("Item adicionado");
                } else throw new ProductNotFoundException(barCode);
            } else {
                System.out.println("Código de barra inválido, código de barra deve conter somente numeros");
            }
        } while (true);
    }

    private int readOption() {
        int option = readInteger(scanner);
        while (option < 1 || option > 6) {
            System.out.println("valor invalido, por favor, digite um valor no conjuto [1,5]");
            option = readInteger(scanner);
        }
        return option;
    }

    private void showMenu() {
        System.out.println("--------------------------");
        System.out.println(
                "1 - Adicionar Item\n" +
                        "2 - Remover Item\n" +
                        "3 - Listar Itens\n" +
                        "4 - Finalizar\n" +
                        "5 - Sair"
        );
    }
}
