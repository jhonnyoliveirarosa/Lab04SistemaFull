package view;

import model.Lab02ContaCorrente;

import java.util.Scanner;

public class Lab02Sistema {
    Lab02ContaCorrente conta = new Lab02ContaCorrente();

    public static void main(String[] args) {
        new Lab02Sistema().execSistema();
    }

    private void execSistema() {
        Scanner leia = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("4 - Dados do Cliente");
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
                case 4:
                    imprimir();
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

    public void execCadastramento() {
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
        if (conf.equalsIgnoreCase("s")) {
            this.conta.setNumAge(nAgencia);
            this.conta.setNumConta(nConta);
            this.conta.setNome(cliente);
            this.conta.setSaldo(saldo);

            System.out.println("Cadastro Realizado");
        }
    }

    public void execSaque() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Numero da Agencia;");
        int nAgencia = leia.nextInt();
        System.out.println("Numero da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Valor do Saque:");
        double saque = leia.nextDouble();
        System.out.println("Confirma o Saque: S/N");
        String conf = leia.next();
        if (conf.equalsIgnoreCase("s")) {
            int retorno = this.conta.sacar(saque);
            if (retorno == 1) {
                System.out.println("Saque Realizado");
            } else {
                System.out.println("Saldo insuficiente");
            }

        }
    }

    public void execDeposito() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Numero da Agencia:");
        int nAgencia = leia.nextInt();
        System.out.println("Numero da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Valor do Deposito:");
        double vDeposito = leia.nextDouble();
        System.out.println("Confirma o Deposito: S/N");
        String conf = leia.next();
        if (conf.equalsIgnoreCase("s")) {
            this.conta.depositar(vDeposito);
            System.out.println("Deposito Realizado");
        }
    }

    public void imprimir() {
        conta.dadosCliente();
    }

}
