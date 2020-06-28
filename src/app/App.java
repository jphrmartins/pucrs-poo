package app;

import entities.MenuOptions;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int option = 1;

        while (option >=1 && option <= 4) {
            MenuOptions.mainOptions();
            option = readOption(scanner);
            menu.chooseOptions(option);
        }
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

    private static boolean numberIsOutOfRange(int number) {
        return number < 1 || number > 4;
    }
}
