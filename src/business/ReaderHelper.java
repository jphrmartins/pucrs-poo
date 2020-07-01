package business;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ReaderHelper {
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

    public static String readBarCode(Scanner scanner) {
        String barCode = scanner.nextLine();
        while (!Pattern.matches("^[0-9]+$", barCode)) {
            System.out.println("Codigo de barras inválido, por favor, entre com um código de barras validos");
            System.out.println("Código de barras devem conter somente numeros");
            barCode = scanner.nextLine();
        }
        return barCode;
    }
}
