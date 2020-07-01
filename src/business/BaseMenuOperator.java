package business;

import entities.MenuRange;
import entities.MenuType;

public interface BaseMenuOperator {
    String getMenuText();
    MenuRange getMenuRange();
    MenuType getMenuType();
    void operate(int option);
}
