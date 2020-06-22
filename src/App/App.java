package App;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();
        int option = 0;

        while (option != 4) {
            menu.mainMenuOptions();
            option = menu.readReply();
            menu.dashBoard(option);
        }
    }
}
