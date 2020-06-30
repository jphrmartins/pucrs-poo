package business;

import java.util.Scanner;

public class NumberReader {
    public static double readDouble(Scanner scanner) {
        String textDouble = scanner.nextLine();
        while (true) {
            try {
                return Double.parseDouble(textDouble);
            } catch (NumberFormatException ex) {
                System.out.println("Valor '" + textDouble + "' não é um numero, por favor, insira um número válido");
                textDouble = scanner.nextLine();
            }
        }
    }

    public static int readInteger(Scanner scanner) {
        String textInt = scanner.nextLine();
        while (true) {
            try {
                return Integer.parseInt(textInt);
            } catch (NumberFormatException ex) {
                System.out.println("Valor '" + textInt + "' não é um numero, por favor, insira um número válido");
                textInt = scanner.nextLine();
            }
        }
    }
}
