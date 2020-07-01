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
        System.out.print("Entre com o código de barras do produto: ");
        String barCode = readBarCode();
        Product product = stock.findProduct(barCode);
        if (product != null){
            System.out.println("Produto encontrado: " + product);
            System.out.print("\n" + "Entre com a quantidade: ");
            int amount = readInteger(scanner);
            stock.stockAdjust(barCode, amount);
        }else{
            System.out.println("Produto não encontrado no estoque. \n" +
                    "Deseja cadastrar este produto <S,N>? ");
            String option = scanner.nextLine();
            if (option.equals("S")) registerNewProduct();
        }
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
        while(!Pattern.matches("^[0-9]+$", barCode)) {
            System.out.println("Codigo de barras inválido, por favor, entre com um código de barras validos");
            System.out.println("Código de barras devem conter somente numeros");
            barCode = scanner.nextLine();
        }
        return barCode;
    }

}
