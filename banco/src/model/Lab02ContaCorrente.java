package model;

public class Lab02ContaCorrente {
    int numAge;
    int numConta;
    String nome;
    double saldo;

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
        System.out.println("Nume da Conta:" + getNumConta());
        System.out.println("Numero da Agencia:" + getNumAge());
        System.out.println("Nome do Cliente:" + getNome());
        System.out.println("Saldo:" + getSaldo());
        System.out.println("------------------------");
    }

    public int getNumAge() {
        return numAge;
    }

    public void setNumAge(int numAge) {
        this.numAge = numAge;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
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
