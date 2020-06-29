package app;

import business.SalesMenu;
import business.StockMenu;
import entities.menu.MenuType;
import entities.product.stock.Stock;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock();
        Menu menu = new Menu(Arrays.asList(new SalesMenu(stock),new StockMenu(stock, scanner)), scanner);
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
        int number = scanner.nextInt();
        while (numberIsOutOfRange(number)) {
            System.out.println("Por favor, digite um numero dentro do conjuto [1,4]: ");
            number = scanner.nextInt();
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
