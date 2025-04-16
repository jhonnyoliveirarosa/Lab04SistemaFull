package view;

import java.util.Scanner;

public class Lab01Sistema {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("9 - Fim");
            System.out.println("Digite um Valor:");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    execCadastramento();
                    break;
                case 2:
                    execSaque();
                    break;
                case 3:
                    execDeposito();
                    break;
                case 9:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Valor Invalido!");
                    break;
            }
        }
    }

    public static void execCadastramento() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Numero da Agencia:");
        int nAgencia = leia.nextInt();
        System.out.println("Numero da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Nome do Cliente:");
        String cliente = leia.next();
        System.out.println("Saldo:");
        double saldo = leia.nextDouble();
        System.out.println("Confirma o cadastramento: S/N");
        String conf = leia.next();
        if(conf.equalsIgnoreCase("s")){
            System.out.println("Cadastro Realizado");
        }
    }

    public static void execSaque() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Numero da Agencia;");
        int nAgencia = leia.nextInt();
        System.out.println("Numero da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Valor do Saque:");
        double vSaque = leia.nextDouble();
        System.out.println("Confirma o Saque: S/N");
        String conf = leia.next();
        if(conf.equalsIgnoreCase("s")){
            System.out.println("Saque Realizado");
        }
    }

    public static void execDeposito() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Numero da Agencia:");
        int nAgencia = leia.nextInt();
        System.out.println("Numero da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Valor do Deposito:");
        double vDeposito = leia.nextDouble();
        System.out.println("Confirma o Deposito: S/N");
        String conf = leia.next();
        if(conf.equalsIgnoreCase("s")){
            System.out.println("Deposito Realizado");
        }
    }

}
