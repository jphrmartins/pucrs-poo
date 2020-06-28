package app;

import business.SalesMenu;
import entities.menu.MenuType;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(Arrays.asList(new SalesMenu()), scanner);
        int option = 1;

        while (option >= 1 && option <= 4) {
            System.out.println(showMenu());
            option = readOption(scanner);
            MenuType menuType = chooseOptions(option);
            if (menuType == MenuType.QUIT) break;
            else menu.executeType(menuType);
        }
    }

    private static String showMenu() {
        return "1 - Vendas \n" +
                "2 - Controle de estoque \n" +
                "3 - Relatorios \n" +
                "4 - Sair";
    }

    private static int readOption(Scanner scanner) {
        int number = 1;
        while (numberIsOutOfRange(number)) {
            number = scanner.nextInt();
            if (numberIsOutOfRange(number)) {
                System.out.println("Por favor, digite um numero dentro do conjuto [1,4]: ");
            }
        }
        return number;
    }

    private static MenuType chooseOptions(int option) {
        switch (option) {
            case 1:
                return MenuType.SALES;
            case 2:
                return MenuType.STOCK_CONTROL;
            case 3:
                return MenuType.REPORTS;
            default:
                return MenuType.QUIT;
        }
    }

    private static boolean numberIsOutOfRange(int number) {
        return number < 1 || number > 4;
    }
}
