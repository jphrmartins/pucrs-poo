package app;

import entityes.MenuOptions;

import java.util.Scanner;

public class Menu {
    public static Scanner in = new Scanner(System.in);

    public void dashBoard(int option){
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
            default:
                if(option != 4)
                System.out.println("Opição invalida nesse Menu");
        }
    }

    public int readReply() {
        System.out.println("Digite o número do comando que deseja executar:");
        try {
            return in.nextInt();
        } catch (NumberFormatException exception) {
            System.out.println("O programa só aceita números inteiros");
        }
        return 4;
    }

    public void salesMenu(){
        int option;
        MenuOptions.salesOptions();
        option = readReply();
        switch (option){
            case 1:
                // TODO: 28/06/2020  
        }

    }

    public void stockControlMenu(){

    }
    
    public void reportMenu(){
        
    }
}