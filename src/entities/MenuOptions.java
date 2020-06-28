package entities;

public class MenuOptions {

    public static void mainOptions(){
        System.out.println("1 - Vendas \n" +
                "2 - Controle de estoque \n" +
                "3 - Relatorios \n" +
                "4 - Sair"
        );
    }

    public static void salesOptions(){
        System.out.println("1 - Realizar Venda \n" +
                "2 - Cancelar Venda \n" +
                "3 - Listar Vendas \n" +
                "4 - Segunda Via \n" +
                "5 - Voltar"
        );
    }

    public static void stockOptions() {
        System.out.println("1 - Cadastrar novo pruduto \n" +
                "2 - Listar todos os p´rodutos \n" +
                "3 - Repor produto em estoque \n" +
                "4 - Voltar"
        );
    }

}
