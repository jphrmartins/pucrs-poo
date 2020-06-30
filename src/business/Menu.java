package business;

import entities.MenuRange;
import entities.MenuType;

import java.util.List;
import java.util.Scanner;

import static business.NumberReader.readInteger;

public class Menu {

    private List<MenuOperator> menuOperators;
    private Scanner scanner;

    public Menu(List<MenuOperator> menuOperators, Scanner scanner) {
        this.menuOperators = menuOperators;
        this.scanner = scanner;
    }

    public void executeType(MenuType menuType) {
        for (MenuOperator menuOperator : menuOperators) {
            if (menuOperator.getMenuType() == menuType) {
                System.out.println(menuOperator.getMenuText());
                int option = readReply(menuOperator.getMenuRange());
                while (option >= menuOperator.getMenuRange().getStartRange() && option < menuOperator.getMenuRange().getEndRange()) {
                    menuOperator.operate(option);
                    System.out.println("===============================");
                    System.out.println(menuOperator.getMenuText());
                    option = readReply(menuOperator.getMenuRange());
                }
            }
        }
    }

    private int readReply(MenuRange menuRange) {
        int number = 0;
        System.out.println("Digite o número do comando que deseja executar: ");
        boolean validNumber = false;
        while (!validNumber) {
            number = readInteger(scanner);
            if (number < menuRange.getStartRange() || number > menuRange.getEndRange()) {
                System.out.println("Por favor, insira um número dentro do conjunto [" + menuRange.getStartRange()
                        + "," + menuRange.getEndRange() + "]");
            } else {
                validNumber = true;
            }
        }
        return number;
    }
}
