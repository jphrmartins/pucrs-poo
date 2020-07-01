package business;

import entities.MenuRange;
import entities.MenuType;

import java.util.List;
import java.util.Scanner;

import static business.NumberReader.readInteger;

public class Menu {

    private List<BaseMenuOperator> baseMenuOperators;
    private Scanner scanner;

    public Menu(List<BaseMenuOperator> baseMenuOperators, Scanner scanner) {
        this.baseMenuOperators = baseMenuOperators;
        this.scanner = scanner;
    }

    public void executeType(MenuType menuType) {
        for (BaseMenuOperator baseMenuOperator : baseMenuOperators) {
            if (baseMenuOperator.getMenuType() == menuType) {
                System.out.println(baseMenuOperator.getMenuText());
                int option = readReply(baseMenuOperator.getMenuRange());
                while (option >= baseMenuOperator.getMenuRange().getStartRange() && option < baseMenuOperator.getMenuRange().getEndRange()) {
                    baseMenuOperator.operate(option);
                    System.out.println("===============================");
                    System.out.println(baseMenuOperator.getMenuText());
                    option = readReply(baseMenuOperator.getMenuRange());
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
