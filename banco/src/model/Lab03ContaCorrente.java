package model;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Lab03ContaCorrente {
    private int numAge;
    private int numConta;
    private String nome;
    private double saldo;

    //recuperar//pesquisa
    public Lab03ContaCorrente(int agencia, int conta){
        this.numAge = agencia;
        this.numConta = conta;

        recuperar();

    }
    public Lab03ContaCorrente(int agencia, int conta, double saldo, String nome){
        this.numAge = agencia;
        this.numConta = conta;
        this.saldo = saldo;
        this.nome = nome;

    }
    public boolean gravar(){
        FileWriter tArq1;
        PrintWriter tArq2;
        try {
            // Operação I - Abrir o aquivo
            tArq1 = new FileWriter(getNumAge() + "." + getNumConta() + ".dat");
            tArq2 = new PrintWriter(tArq1);
            tArq2.println(getNumAge());
            tArq2.println(getNumConta());
            tArq2.println(getNome());
            tArq2.println(getSaldo());
            tArq2.close();
            // Operação II - Fechar o arquivo
            return true;
        }
        catch (IOException e){
            System.err.println("Erro ao recuperar os dados: " + e.getMessage());
        }
        return false;
    }

    private void recuperar() {
        // abrir o arquivo de texto
        FileReader tArq1;
        // ler LINHA por LINHA o arquivo de forma mais eficiente
        BufferedReader tArq2;
        //quantas linhas ira ler
        int qtd = 4;

        try {
            // Operação I - Abrir o arquivo
            tArq1 = new FileReader(getNumAge() + "." + getNumConta() + ".dat");
            tArq2 = new BufferedReader(tArq1);

            // Operação II - Ler atributo/valor e colocar na matriz
            String[] tLinha = new String[qtd];

            for (int i = 0; i < qtd; i++) {
                tLinha[i] = tArq2.readLine();
            }
            // Operação III - Fechar o arquivo
            tArq2.close();
            setNumAge(Integer.parseInt(tLinha[0]));
            setNumConta(Integer.parseInt(tLinha[1]));

            setNome(tLinha[2]);
            setSaldo(Double.parseDouble(tLinha[3]));


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public int sacar(double vSaque) {
        if (this.saldo >= vSaque) {
            this.saldo = this.saldo - vSaque;

            return 1;
        }
        return 0;
    }

    public void depositar(double vDeposito) {
        this.saldo = vDeposito + this.saldo;

    }

    public void dadosCliente() {

        System.out.println("----Dados do Cliente----");
        System.out.println("Número da Conta:" + getNumConta());
        System.out.println("Número da Agência:" + getNumAge());
        System.out.println("Nome do Cliente:" + getNome());

        NumberFormat formatter = DecimalFormat.getCurrencyInstance(new Locale("pt","BR"));
        formatter.setMinimumFractionDigits(2);
        System.out.println("Saldo: " + formatter.format(getSaldo()));
        System.out.println("------------------------");
    }

    public int getNumAge() {
        return numAge;
    }

    public void setNumAge(int numAge) {
        while (numAge < 1 || numAge > 9999) {
            System.out.println("Erro: O Número da Agência deve ser entre 1 e 9999.");
            System.out.print("Digite um Número de Agência válido: ");
            Scanner leia = new Scanner(System.in);
            numAge = leia.nextInt();
        }
        this.numAge = numAge;
    }

    public int getNumConta() {
            return numConta;
    }

    public void setNumConta(int numConta) {
        while(numConta < 1 || numConta >9999999){
            System.out.println("Erro: O Número da Agência deve ser entre 1 e 9999.");
            System.out.print("Digite um Número de Agência válido: ");
            Scanner leia = new Scanner(System.in);
            numConta = leia.nextInt();
        }

            this.numConta = numConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
