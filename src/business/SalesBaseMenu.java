package business;

import app.SystemDependencies;
import entities.*;

import java.util.Scanner;


public class SalesBaseMenu implements BaseMenuOperator {

    private Stock stock;
    private Scanner scanner;
    private SalesBase salesBase;
    private SubMenuOperator<Sale> saleSubMenuSale;

    public SalesBaseMenu(SubMenuOperator<Sale> saleSubMenuSale, SystemDependencies systemDependencies, Scanner scanner) {
        this.stock = systemDependencies.getStock();
        this.salesBase = systemDependencies.getSalesBase();
        this.saleSubMenuSale = saleSubMenuSale;
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
                cancelSale();
                break;
            case 3:
                salesBase.getAllSales().forEach(System.out::println);
                break;
            case 4:
                regenerateReceipt();
                break;
            default:
                break;
        }
    }

    private void cancelSale() {
        System.out.println("Para cancelar uma venda, digite o id da venda");
        int saleId = ReaderHelper.readInteger(scanner);
        try {
            Sale sale = salesBase.find(saleId);
            updateBase(sale);
        } catch (SaleNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void updateBase(Sale sale) {
        stock.updateForCancelSale(sale);
        salesBase.cancelSale(sale);
    }

    private void regenerateReceipt() {
        System.out.println("Para gerar a segunda via do recibo, por favor, digite o id da venda");
        int saleId = ReaderHelper.readInteger(scanner);
        try {
            Sale sale = salesBase.find(saleId);
            System.out.println(sale.generateReceipt());
        } catch (SaleNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void registerSale() {
        saleSubMenuSale.operate(new Sale());
    }
}
