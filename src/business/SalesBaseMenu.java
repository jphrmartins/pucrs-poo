package business;

import entities.*;

import java.util.Scanner;

public class SalesBaseMenu implements BaseMenuOperator {

    private Stock stock;
    private SalesBase salesBase;
    private SubMenuOperator<Sale> saleSubMenuSale;

    public SalesBaseMenu(SubMenuOperator<Sale> saleSubMenuSale, Stock stock, SalesBase salesBase) {
        this.stock = stock;
        this.salesBase = salesBase;
        this.saleSubMenuSale = saleSubMenuSale;
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
        saleSubMenuSale.operate(new Sale());
    }
}
