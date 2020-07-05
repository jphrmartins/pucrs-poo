package business;

import entities.*;

import java.util.Scanner;

import static business.ReaderHelper.*;

public class StockBaseMenu implements BaseMenuOperator {
    private Stock stock;
    private Scanner scanner;

    public StockBaseMenu(Stock stock, Scanner scanner) {
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
        String barCode = readBarCode(scanner);
        Product product = stock.getProduct(barCode);
        if (product != null){
            System.out.println("Produto encontrado: " + product);
            System.out.print("Entre com a quantidade: ");
            int amount = readInteger(scanner);
            stock.stockAdjust(barCode, amount);
        }else{
            System.out.println("Produto não encontrado no estoque. \n" +
                    "Deseja cadastrar este produto <S,N>? ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("S")) registerNewProduct();
        }
    }

    private void listAllProducts() {
        stock.getAllProducts().forEach(System.out::println);
    }

    private void registerNewProduct() {
        System.out.println("Entre com a descrição, preço, código de barras e quantidade inicial do estoque.");
        System.out.print("Código de barras: ");
        String barCode = readBarCode(scanner);
        System.out.print("Descrição: ");
        String description = readDescription(scanner);
        System.out.print("Preço: ");
        double price = readDouble(scanner);
        System.out.print("Quantidade: ");
        int amount = readInteger(scanner);
        if (!stock.hasProduct(barCode))
        stock.addProduct(new Product(description, price, barCode, amount));
        else System.out.println("Este produto ja existe no estoque");
    }
}
