package business;

import entities.MenuRange;
import entities.MenuType;
import entities.Stock;

public class SalesMenu implements MenuOperator {

    private Stock stock;

    public SalesMenu(Stock stock) {
        this.stock = stock;
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

    }
}
