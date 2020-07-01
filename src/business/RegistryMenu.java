package business;

import entities.Product;
import entities.Sale;
import entities.SalesBase;
import entities.Stock;

import java.util.Scanner;
import java.util.regex.Pattern;

import static business.NumberReader.readInteger;

public class RegistryMenu implements SubMenuOperator {

    private Scanner scanner;
    private Stock stock;
    private SalesBase salesBase;
    private Sale sale;

    public RegistryMenu(Scanner scanner, Stock stock, SalesBase salesBase) {
        this.scanner = scanner;
        this.stock = stock;
        this.salesBase = salesBase;
        this.sale = new Sale();
    }

    @Override
    public void operate() {
        System.out.println("===============");
        showMenu();
        int option = readOption();
        switch (option) {
            case 1:
                addItem();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void addItem() {
        String in;
        do {
            System.out.println("Entre com o código de barras ou 'S' para sair");
            in = scanner.nextLine();
            if (Pattern.matches("^[0-9]+$", in)) {
                Product product = stock.getProduct(in);
                if (product != null) {
                    sale.addItem(product);
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
        System.out.println(
                "1 - Adicionar Item\n" +
                        "2 - Remover Item\n" +
                        "3 - Finalizar"
        );
    }
}
