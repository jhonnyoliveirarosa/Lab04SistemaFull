package model;


import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Lab04Historico {
    private int numAge = 0;
    private int numConta = 0;

    private ArrayList<String> vetOperacoes = new ArrayList<String>();

    public Lab04Historico(int numAge, int numConta) {
        this.numAge = numAge;
        this.numConta = numConta;

    }

    public boolean gravar(int codHist, double valor) {
        FileWriter tArq1;
        PrintWriter tArq2;
        try{
            tArq1 =  new FileWriter(numAge+ "." +numConta+ ".hist", true);
            tArq2 = new PrintWriter(tArq1);
            //PEGANDO A DATA E HORA ATUAL
            Date hoje = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTime(hoje);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH)+1;
            int ano = cal.get(Calendar.YEAR);
            int hora = cal.get(Calendar.HOUR);
            int min = cal.get(Calendar.MINUTE);
            int seg = cal.get(Calendar.SECOND);

            //ESCREVENDO NO ARQUIVO OS DADOS SOBRE A TRANSAÇÃO
            tArq2.println(numAge+"");
            tArq2.println(numConta+"");
            tArq2.println(dia+"");
            tArq2.println(mes+"");
            tArq2.println(ano+"");
            tArq2.println(hora+"");
            tArq2.println(min+"");
            tArq2.println(seg+"");
            tArq2.println(codHist+"");
            tArq2.println(valor+"");
            tArq2.close();
            return true;



        } catch (IOException tExcept) {
            tExcept.printStackTrace();
            return false;
        }

    }

    public void imprimir() {
        recuperarHistorico();

        for (int i = 0; i < vetOperacoes.size(); i += 10) {
            int agencia = Integer.parseInt(vetOperacoes.get(i));
            int conta = Integer.parseInt(vetOperacoes.get(i + 1));
            int dia = Integer.parseInt(vetOperacoes.get(i + 2));
            int mes = Integer.parseInt(vetOperacoes.get(i + 3));
            int ano = Integer.parseInt(vetOperacoes.get(i + 4));
            int hora = Integer.parseInt(vetOperacoes.get(i + 5));
            int min = Integer.parseInt(vetOperacoes.get(i + 6));
            int seg = Integer.parseInt(vetOperacoes.get(i + 7));
            int codHist = Integer.parseInt(vetOperacoes.get(i + 8));
            double valor = Double.parseDouble(vetOperacoes.get(i + 9));

            String tipo = (codHist == 1) ? "saque" : "deposito";
            // Formatando o valor com moeda BR
            NumberFormat valorFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            valorFormatter.setMinimumFractionDigits(2);

            // Formatando agência e conta com zeros à esquerda
            NumberFormat agFormatter = new DecimalFormat("0000");
            NumberFormat contaFormatter = new DecimalFormat("0000000");

            String agenciaFormatada = agFormatter.format(agencia);
            String contaFormatada = contaFormatter.format(conta);


            System.out.printf("[%02d/%02d/%04d - %02d:%02d:%02d] Agência: %s | Conta: %s | %s de %s\n",
                    dia, mes, ano, hora, min, seg, agenciaFormatada, contaFormatada, tipo, valorFormatter.format(valor));
        }

    }

    public void recuperarHistorico() {
        FileReader tArq1;
        BufferedReader tArq2;
        String tLinha = null;
        try {
            // Operação I - Abrir o arquivo
            tArq1 = new FileReader(numAge+"."+numConta+".hist");
            tArq2 = new BufferedReader(tArq1);
            // Operação III - Ler atributo/valor e colocar na matriz
            while(true){
                tLinha = tArq2.readLine();
                if(tLinha == null){
                    break;
                }
                vetOperacoes.add(tLinha);
            }

            tArq2.close();
        }catch (FileNotFoundException e) {
            System.out.println("\n Conta sem movimento \n\n");
        }
        catch (IOException tExcept){
            System.out.println("Algo deu errado!");
        }


    }
    public boolean removerArquivo(){
        File tArq1;
        tArq1 = new File(numAge+"."+numConta+".dat");
        tArq1.delete();
        tArq1 = new File(numAge+"."+numConta+".hist");
        tArq1.delete();
        return true;
    }

}
