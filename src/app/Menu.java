package app;

import entities.MenuOptions;

import java.util.Scanner;

public class Menu {
    public static Scanner in = new Scanner(System.in);

    public void chooseOptions(int option){
        switch (option){
            case 1:
                salesMenu();
                break;
            case 2:
                stockControlMenu();
                break;
            case 3:
                reportMenu();
                break;
            default: break;
        }
    }

    private void salesMenu(){
        int option;
        MenuOptions.salesOptions();
        option = readReply(1, 5);
        switch (option){
            case 1:
                // TODO: 28/06/2020  
        }

    }

    private void stockControlMenu(){

    }
    
    private void reportMenu(){
        
    }

    private int readReply(int startRange, int endRange) {
        int number = 0;
        System.out.println("Digite o número do comando que deseja executar: ");
        boolean validNumber = false;
        while (!validNumber) {
            try {
                number = in.nextInt();
                if (number < startRange || number > endRange) {
                    System.out.println("Por favor, insira um número dentro do conjunto [" + startRange + "," + endRange + "]");
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
