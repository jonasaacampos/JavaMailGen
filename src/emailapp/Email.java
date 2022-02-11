package emailapp;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Email {

    public Scanner entrada = new Scanner(System.in);

    /**
     * Variáveis privadas para impedir o acesso diretamente
     */

    private String nome;
    private String sobrenome;
    private String departamento;
    private String email;
    private String password;
    private String emailSecundario;
    private int capacidadeCaixaEmailMb = 500;

    public Email(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        System.out.println("Novo funcionário: " + this.nome + " " + this.sobrenome);

        this.departamento = this.setDepartamento();
        this.password = this.generatePassword(10);
        this.email = this.generateEmail();

    }

    //gerador de email
    private String generateEmail() {
        return this.nome.toLowerCase() + "." + this.sobrenome.toLowerCase() + "@" + this.departamento.toLowerCase() + "xpto.com";
    }


    private String setDepartamento() {

        System.out.println("Código dos departamentos: ");
        System.out.println("1 - Comercial \n2 - Suporte\n3 - Financeiro\n0 - CHEFIA \uD83D\uDE1C\uD83D\uDE1C");

        boolean flag = false;

        do {
            System.out.println("Digite o código do departamento...");
            int escolherDepartamento = entrada.nextInt();
            switch (escolherDepartamento) {
                case 1:
                    return "Comercial";
                case 2:
                    return "Suporte";
                case 3:
                    return "Financeiro";
                case 0:
                    return "Nenhum";
                default:
                    System.out.println("Opção Inválida.");
            }
        } while (!flag);
        return null;
    }

    //gerar senha
    private String generatePassword(int tamanhoSenha) {
        Random random = new Random();
        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiais = "@#$%&*()_+=-";

        String todasAsPossibilidades = letrasMaiusculas + letrasMinusculas + numeros + especiais;
        StringBuilder password = new StringBuilder();

        for (int possibilidade = 0; possibilidade < tamanhoSenha; possibilidade++) {
            password.append(todasAsPossibilidades.charAt(random.nextInt(todasAsPossibilidades.length())));
        }
        return password.toString();
    }

    public void setPassword() {
        boolean flag = false;

        do {
            System.out.println("Gostaria de alterar sua senha? (S/N)");
            char opcaoMudarSenha = entrada.next().charAt(0);

            assert toString(opcaoMudarSenha) != null;
            if ("S".equalsIgnoreCase(toString(opcaoMudarSenha))) {
                flag = true;
                System.out.println("Insira a senha atual: ");
                String temp = entrada.next();
                if (temp.equals(this.password)) {
                    System.out.println("Insira sua nova senha...");
                    this.password = entrada.next();
                    System.out.println("Senha alterada com sucesso!!!");
                } else {
                    System.out.println("Senha Incorreta");
                }
            } else if ("N".equalsIgnoreCase(toString(opcaoMudarSenha))) {
                flag = true;
                System.out.println("Mudança de senha cancelada");
            } else {
                System.out.println("Insira uma opção válida!");
            }
        } while (!flag);


    }

    private String toString(char opcaoMudarSenha) {
        return null;
    }

    public void setCapacidadeCaixaEmailMb() {
        System.out.println("Capacidade atual = " + this.capacidadeCaixaEmailMb + "Mb");
        System.out.println("Entre a nova capacidade da caixa de entrada: ");
        this.capacidadeCaixaEmailMb = entrada.nextInt();
        System.out.println("Capacidade ca caixa de entrada alterada.");
    }

    public void emailAlternativo() {
        System.out.println("Insira um email alternativo: ");
        this.emailSecundario = entrada.next();
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void getInfo() {
        System.out.println("Funcionário: " + this.nome + " " + this.sobrenome);
        System.out.println("Departament: " + this.departamento);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Capacidade da caixa de entrada: " + this.capacidadeCaixaEmailMb + "Mb");
        System.out.println("Email alternativo: " + this.emailSecundario);
    }

    public void storeFile() {
        try {
            FileWriter in = new FileWriter("C:\\MailLog\\info.txt");
            in.write("Nome: " + this.nome + " " + this.sobrenome);
            in.append("Departament: " + this.departamento);
            in.append("Email: " + this.email);
            in.append("Password: " + this.password);
            in.append("Capacidade da caixa de entrada: " + this.capacidadeCaixaEmailMb + "Mb");
            in.append("Email alternativo: " + this.emailSecundario);
            in.close();

            System.out.println("Arquivo salvo com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFile() {
        try {
            FileReader f1 = new FileReader("C:\\MailLog\\info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.println((char) i);
            }
            System.out.println();
            f1.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
