package business;

import entities.MenuRange;
import entities.MenuType;

public interface MenuOperator {
    String getMenuText();
    MenuRange getMenuRange();
    MenuType getMenuType();
    void operate(int option);
}
