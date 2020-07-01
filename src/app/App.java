package app;

import business.Menu;
import business.RegistryMenu;
import business.SalesBaseMenu;
import business.StockBaseMenu;
import entities.MenuType;
import entities.SalesBase;
import entities.Stock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static business.NumberReader.readInteger;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock();
        SalesBase salesBase = new SalesBase(new HashMap<>());
        Menu menu = new Menu(Arrays.asList(new SalesBaseMenu(stock, salesBase), new StockBaseMenu(stock, scanner)), scanner);
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
