package view;

import model.Lab03ContaCorrente;

import java.util.Scanner;

public class Lab03Sistema {
    Scanner leia = new Scanner(System.in);


    public static void main(String[] args) {
        new Lab03Sistema().execSistema();
    }

    private void execSistema() {

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Depósito");
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
                    System.out.println("Fim!");
                    break;
                default:
                    System.out.println("Valor Inválido!");
                    break;
            }
        }
    }

    public void execCadastramento() {

        System.out.println("Número da Agência:");
        int nAgencia = leia.nextInt();
        System.out.println("Número da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Nome do Cliente:");
        String cliente = leia.next();
        System.out.println("Saldo:");
        double saldo = leia.nextDouble();
        System.out.println("Confirma o cadastramento: S/N");
        String conf = leia.next();
        if (conf.equalsIgnoreCase("s")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(nAgencia, nConta, saldo, cliente);
            conta.setNumAge(nAgencia);
            conta.setNumConta(nConta);

            conta.gravar();
            System.out.println("Cadastro Realizado");
        }
    }

    public void execSaque() {

        System.out.println("Número da Agência;");
        int nAgencia = leia.nextInt();
        System.out.println("Número da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Valor do Saque:");
        double saque = leia.nextDouble();
        System.out.println("Confirma o Saque: S/N");
        String conf = leia.next();
        if (conf.equalsIgnoreCase("s")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(nAgencia, nConta);

            int retorno = conta.sacar(saque);
            if (retorno == 1) {
                System.out.println("Saque Realizado");
                conta.gravar();
            } else {
                System.out.println("Saldo insuficiente");
            }

        }
    }

    public void execDeposito() {

        System.out.println("Número da Agência:");
        int nAgencia = leia.nextInt();
        System.out.println("Número da Conta:");
        int nConta = leia.nextInt();
        System.out.println("Valor do Deposito:");
        double vDeposito = leia.nextDouble();
        System.out.println("Confirma o Depósito: S/N");
        String conf = leia.next();
        if (conf.equalsIgnoreCase("s")) {
            Lab03ContaCorrente conta = new Lab03ContaCorrente(nAgencia, nConta);

            conta.depositar(vDeposito);
            conta.gravar();
            System.out.println("Depósito Realizado");
        }
    }

    public void imprimir() {

        System.out.println("Digite o Número da Agência:");
        int nAgencia = leia.nextInt();
        System.out.println("Digite o Número da Conta:");
        int nConta = leia.nextInt();
        Lab03ContaCorrente conta = new Lab03ContaCorrente(nAgencia, nConta);
        conta.dadosCliente();
    }

}
