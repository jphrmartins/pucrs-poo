package app;

import business.*;
import entities.MenuType;


import java.util.Arrays;
import java.util.Scanner;

import static business.ReaderHelper.readInteger;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemDatabase database = new FileSystemDatabase();
        SystemDependencies system = database.loadSystem();
        Menu menu = new Menu(Arrays.asList(
                new SalesBaseMenu(system, scanner),
                new StockBaseMenu(system.getStock(), scanner),
                new ReportBaseMenu(system.getSalesBase())
        ), scanner);
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
        int number = readInteger(scanner);
        while (numberIsOutOfRange(number)) {
            System.out.println("Por favor, digite um numero dentro do conjunto [1,4]: ");
            number = readInteger(scanner);
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
