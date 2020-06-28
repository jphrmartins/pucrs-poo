package business;

import entities.menu.MenuRange;
import entities.menu.MenuType;
import entities.product.stock.Stock;
import entities.product.stock.StockItem;

import java.util.Scanner;

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
        return new MenuRange(1,4);
    }

    @Override
    public MenuType getMenuType() {
        return MenuType.STOCK_CONTROL;
    }

    @Override
    public void operate(int option) {

        switch (option){
            case 1:
                String description = "";
                double price = 0;
                String barCode = "";
                int amount = 0;
                System.out.println("Entre com a descrição, preço, código de barras e quantidae inicial do estoque.");
                System.out.print("Descrição: ");
                description = scanner.nextLine();
                System.out.print("\n" + "Preço: ");
                price = scanner.nextDouble();
                System.out.print("\n" + "Código de barras: ");
                barCode = scanner.nextLine();
                System.out.println("\n" + "Quantidade: ");
                amount = scanner.nextInt();
                stock.addProduct(new StockItem(description, price, barCode, amount));
        }
    }
}
