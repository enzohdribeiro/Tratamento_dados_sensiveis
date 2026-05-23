package test;

import model.Client;
import service.SensitiveDataTreat;

public class Test {
    public static void main(String[] args) {
        String treatedMessage;
        Client c1 = new Client("Ana", "123.456.789-00", "Ana@gmail.com");

        String serverMessageEx ="Cliente "+c1.getEmail()+" com o CPF "+c1.getCpf()+" Realizou uma compra.\n";
        System.out.println(serverMessageEx);

        treatedMessage = SensitiveDataTreat.sensitiveDataMasking(serverMessageEx);
        System.out.println(treatedMessage);
    }
}
