package app;

import entityes.MenuOptions;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();
        int option = 1;

        while (option >=1 && option <= 4) {
            MenuOptions.mainOptions();
            option = menu.readReply();
            menu.dashBoard(option);
        }
    }
}
