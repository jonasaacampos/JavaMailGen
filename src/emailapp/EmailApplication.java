package emailapp;

import java.util.Scanner;

public class EmailApplication {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Insira seu primeiro nome: ");
        String nome = entrada.next();

        System.out.print("Insira seu sobrenome: ");
        String sobrenome = entrada.next();


        Email mail1 = new Email(nome, sobrenome);
        int escolhaOpcaoUsuario = -1;
        do {
            System.out.println("Digite sua opção: ");
            System.out.println("1. Exibir dados" +
                    "\n2. Alterar senha" +
                    "\n3. Alterar capacidade da caixa de entrada" +
                    "\n4. Inserir email secundário" +
                    "\n5. Exportar informações para um arquivo de texto" +
                    "\n6. Mostrar arquivo" +
                    "\n7. Sair");
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
                case 5:
                    mail1.storeFile();
                    break;
                case 6:
                    mail1.readFile();
                    break;
                case 7:
                    System.out.println("Obrigado por utilizar nossos sistemas");
                    break;
                default:
                    System.out.println("Opção inválida.\nInsira sua opção novamente");
            }


        } while (escolhaOpcaoUsuario != 7);


    }
}
