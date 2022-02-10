package emailapp;

import java.util.Scanner;

public class EmailApplication {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Insira seu primeiro nome: ");
        String nome = entrada.next();

        System.out.println("Insira seu sobrenome: ");
        String sobrenome = entrada.next();


        Email mail1 = new Email(nome, sobrenome);
        int escolhaOpcaoUsuario = -1;
        do {
            System.out.println("Digite sua opção: ");
            System.out.println("1. Mostra aplicação" +
                    "\n 2. Alterar senha" +
                    "\n 3. Alterar capacidade da caixa de entrada" +
                    "\n 4. Inserir email secundário" +
                    "\n 5. Exportar informações para um arquivo de texto" +
                    "\n 6. Mostrar arquivo" +
                    "\n 7. Sair");
            escolhaOpcaoUsuario = entrada.nextInt();

            switch (escolhaOpcaoUsuario) {
                case 1:
                    mail1.getInfo();
                    break;
                case 2:
                    mail1.setPassword();
                    break;
                case 3:
                    mail1.setCapacidadeCaixaEmailMb();
                    break;
                case 4:
                    mail1.emailAlternativo();
                    break;
                case 7:
                    System.out.println("Obrigado por utilizar nossos sistemas");
                    break;
            }


        } while (escolhaOpcaoUsuario != 7);


    }
}