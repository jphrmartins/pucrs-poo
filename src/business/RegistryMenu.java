package business;

import entities.MenuRange;
import entities.MenuType;
import entities.SalesBase;
import entities.Stock;

import java.util.Scanner;

import static business.NumberReader.readInteger;

public class RegistryMenu implements SubMenuOperator {

    private Scanner scanner;
    private Stock stock;
    private SalesBase salesBase;

    public RegistryMenu(Scanner scanner, Stock stock, SalesBase salesBase) {
        this.scanner = scanner;
        this.stock = stock;
        this.salesBase = salesBase;
    }

    @Override
    public void operate() {
        System.out.println("===============");
        showMenu();
        /*
        public
         void "esse é um metodo"() {}
         public void "esse é um numero"() {}
         public void "esse é um texto"() {}

        main () {
        List<String> nomes = ['metodo', 'numero', 'texto']
            nomes.forEach { "esse é um $it"() }
        }
        */
        int option = readOption();
        switch (option) {
            case 1: break;
            case 2: break;
            case 3: break;
        }
    }

    private int readOption() {
        int option = readInteger(scanner);
        while (option < 1 || option > 3) {
            System.out.println("valor invalido, por favor, digite um valor no conjuto [1,3]");
            option = readInteger(scanner);
        }
        return option;
    }

    private void showMenu() {
        System.out.println(
                "1 - Adicionar Item\n" +
                        "2 - Remover Item\n" +
                        "3 - Finalizar"
        );
    }
}
