package business;

import entities.*;

import java.util.Scanner;
import java.util.regex.Pattern;

import static business.ReaderHelper.readBarCode;
import static business.ReaderHelper.readInteger;

public class SaleSubMenu implements SubMenuOperator<Sale> {

    private Scanner scanner;
    private Stock stock;
    private SalesBase salesBase;
    private Sale sale;

    public SaleSubMenu(Scanner scanner, Stock stock, SalesBase salesBase) {
        this.scanner = scanner;
        this.stock = stock;
        this.salesBase = salesBase;
        this.sale = new Sale();
    }

    @Override
    public void operate(Sale sale) {
        System.out.println("===============");
        int option;
        do {
            showMenu();
            option = readOption();
            switch (option) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    sale.getItems().forEach(System.out::println);
                    break;
                case 4:
                    try {
                        endSale();
                    } catch (CanNotCloseSaleWhithoutItemsExeption ex){
                        System.err.println(ex.getMessage());
                    }
                    break;
            }
        } while (option >= 1 && option < 4);
    }

    private void endSale() {
        if (sale.getItems().isEmpty()) throw new CanNotCloseSaleWhithoutItemsExeption();
        else{
            if (sale.getTotalPrice() >= 250){
                System.out.println("Deseja aplicar desconto S | N ?");
                String option = scanner.next();
                if (option.equalsIgnoreCase("s")){
                    double discount = askDiscount();
                }
            }
        }
    }

    private double askDiscount() {
        System.out.println();
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
    }


    private void addItem() {
        String in;
        do {
            System.out.println("Entre com o código de barras ou 'S' para sair");
            in = scanner.nextLine();
            if (Pattern.matches("^[0-9]+$", in)) {
                Product product = stock.getProduct(in);
                if (product != null) {
                    sale.addItem(new Product(product.getDescription(), product.getPrice(), product.getBarCode(), 1));
                }
            }
        } while (!in.equalsIgnoreCase("s"));
    }

    private int readOption() {
        int option = readInteger(scanner);
        while (option < 1 || option > 3) {
            System.out.println("valor invalido, por favor, digite um valor no conjuto [1,3]");
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
                        "4 - Finalizar"
        );
    }
}
