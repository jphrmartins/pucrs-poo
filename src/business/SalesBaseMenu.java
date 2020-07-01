package business;

import entities.MenuRange;
import entities.MenuType;
import entities.SalesBase;
import entities.Stock;

import java.util.Scanner;

public class SalesBaseMenu implements BaseMenuOperator {

    private Stock stock;
    private SalesBase salesBase;
    private Scanner scanner;

    public SalesBaseMenu(Stock stock, SalesBase salesBase, Scanner scanner) {
        this.stock = stock;
        this.salesBase = salesBase;
        this.scanner = scanner;
    }

    @Override
    public MenuType getMenuType() {
        return MenuType.SALES;
    }

    @Override
    public String getMenuText() {
        return "1 - Realizar Venda \n" +
                "2 - Cancelar Venda \n" +
                "3 - Listar Vendas \n" +
                "4 - Segunda Via \n" +
                "5 - Voltar";
    }

    @Override
    public MenuRange getMenuRange() {
        return new MenuRange(1, 5);
    }

    @Override
    public void operate(int option) {
        switch (option) {
            case 1:
                registerSale();
                break;
            case 2:
                break;
            case 3:
                salesBase.getAllSales().forEach(System.out::println);
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    private void registerSale() {
        new RegistryMenu(scanner,stock,salesBase).operate();
    }
}
