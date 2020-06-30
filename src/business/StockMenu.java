package business;

import entities.*;

import java.util.Scanner;
import java.util.regex.Pattern;

import static business.NumberReader.*;

public class StockMenu implements MenuOperator {
    private Stock stock;
    private Scanner scanner;

    public StockMenu(Stock stock, Scanner scanner) {
        this.stock = stock;
        this.scanner = scanner;
    }

    @Override
    public String getMenuText() {
        return "1 - Cadastrar Novo Produto \n" +
                "2 - Listar Todos os Produtos \n" +
                "3 - Repor Produtos em Estoque \n" +
                "4 - Voltar";
    }

    @Override
    public MenuRange getMenuRange() {
        return new MenuRange(1, 4);
    }

    @Override
    public MenuType getMenuType() {
        return MenuType.STOCK_CONTROL;
    }

    @Override
    public void operate(int option) {
        switch (option) {
            case 1:
               registerNewProduct();
               break;
            case 2:
                listAllProducts();
                break;
            case 3:
                restockItem();
                break;
            default:
                break;

        }
    }

    private void restockItem() {

    }

    private void listAllProducts() {
        stock.getAllProducts().forEach(System.out::println);
    }

    private void registerNewProduct() {
        System.out.println("Entre com a descrição, preço, código de barras e quantidae inicial do estoque.");
        System.out.print("Código de barras: ");
        String barCode = readBarCode();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.print("Preço: ");
        double price = readDouble(scanner);
        System.out.print("Quantidade: ");
        int amount = readInteger(scanner);
        stock.addProduct(new Product(description, price, barCode, amount));
    }

    private String readBarCode() {
        String barCode = scanner.nextLine();
        if (Pattern.matches("[0-9]+", barCode)) {
            return barCode;
        } else {
            throw new InvalidBarCodeException("Codigo de barra deve serguir o padão de somente numeros.");
        }
    }

}
