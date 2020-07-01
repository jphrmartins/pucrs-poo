package business;

import entities.MenuRange;
import entities.MenuType;
import entities.SalesBase;
import entities.Stock;

public class SalesBaseMenu implements BaseMenuOperator {

    private RegistryMenu registryMenu;
    private Stock stock;
    private SalesBase salesBase;

    public SalesBaseMenu(RegistryMenu registryMenu, Stock stock, SalesBase salesBase) {
        this.registryMenu = registryMenu;
        this.stock = stock;
        this.salesBase = salesBase;
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
        registryMenu.operate();
    }
}
