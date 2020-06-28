package business;

import entities.menu.MenuRange;
import entities.menu.MenuType;

public interface MenuOperator {
    String getMenuText();
    MenuRange getMenuRange();
    MenuType getMenuType();
    void operate(int option);
}
