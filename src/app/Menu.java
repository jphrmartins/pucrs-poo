package app;

import business.MenuOperator;
import entities.menu.MenuRange;
import entities.menu.MenuType;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<MenuOperator> menuOperators;
    private Scanner scanner;

    public Menu(List<MenuOperator> menuOperators, Scanner scanner) {
        this.menuOperators = menuOperators;
        this.scanner = scanner;
    }

    public void executeType(MenuType menuType) {
        menuOperators
                .stream()
                .filter(it -> it.getMenuType() == menuType)
                .findFirst()
                .ifPresent(it -> {
                    System.out.println(it.getMenuText());
                    int option = readReply(it.getMenuRange());
                    it.operate(option);
                });
    }

    private int readReply(MenuRange menuRange) {
        int number = 0;
        System.out.println("Digite o número do comando que deseja executar: ");
        boolean validNumber = false;
        while (!validNumber) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number < menuRange.getStartRange() || number > menuRange.getEndRange()) {
                    System.out.println("Por favor, insira um número dentro do conjunto [" + menuRange.getStartRange()
                            + "," + menuRange.getEndRange() + "]");
                } else {
                    validNumber = true;
                }
            } catch (NumberFormatException exception) {
                System.out.println("O programa só aceita números inteiros");
            }
        }
        return number;
    }
}
