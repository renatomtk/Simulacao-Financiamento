package main;

import util.InterfaceUsuario; //importando a classe InterfaceUsuario do pacote util
import modelo.Financiamento; //importando a classe Financiamento do pacote modelo

import java.util.ArrayList; //importando o ArrayList da biblioteca java.util
import java.io.*; //importando a biblioteca io para leitura e escrita de arquivos

public class Main {
    public static void main(String[] args) { //início da aplicação
        InterfaceUsuario usuario = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>();
        double totalImovel = 0;
        double totalFinanciamento = 0;

        double valorImovel = usuario.solicitarValorImovel();
        int prazoFinanciamento = usuario.solicitarPrazoFinanciamento();
        double taxaJuros = usuario.solicitarTaxaJuros();

        listaFinanciamento.add(new modelo.Terreno(valorImovel, prazoFinanciamento, taxaJuros, "Residencial"));
        listaFinanciamento.add(new modelo.Casa(500000, 10, 10, 80, 120));
        listaFinanciamento.add(new modelo.Casa(250000, 15, 10.75, 100, 140));
        listaFinanciamento.add(new modelo.Apartamento(500000, 10, 10, 1, 5));
        listaFinanciamento.add(new modelo.Apartamento(250000, 15, 10.75, 2, 10));

        for(Financiamento financiamento : listaFinanciamento) { //fornece os dados de cada imóvel
            financiamento.dadosFinanciamento();
            totalImovel += financiamento.getValorImovel();
            totalFinanciamento += financiamento.calcularPagamentoTotal();
        }

        System.out.printf("\nValor total de todos os imóveis: R$%.2f" ,totalImovel); //fornece o valor total dos imóveis
        System.out.printf("\nValor total de todos os financiamentos: R$%.2f" ,totalFinanciamento); //fornece o valor total dos financiamentos

        //escrevendo os dados dos financiamentos no arquivo dadosFinanciamento.txt utilizando FileWriter
        try {
            FileWriter out = new FileWriter("dadosFinanciamento.txt", true); //cada financiamento novo será salvo com os demais
            for (Financiamento financiamento : listaFinanciamento) {
                out.write(financiamento.toString() + "\n");
            }
            out.flush();
            out.close();
            System.out.println("\n\nOs dados dos financiamentos foram salvos no arquivo dadosFinanciamento.txt com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //lendo o arquivo dadosFinanciamento.txt utilizando BufferedReader e FileReader
        try {
            BufferedReader in = new BufferedReader(new FileReader("dadosFinanciamento.txt"));
            String line;
            System.out.println("\nLeitura do arquivo dadosFinanciamento.txt:\n");
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //escrevendo os dados serializados dos financiamentos no arquivo dadosSerializadosFinanciamentos.teste utilizando ObjectOutputStream e FileOutputStream
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("dadosSerializadosFinanciamentos.teste"));
            for (Financiamento financiamento : listaFinanciamento) {
                objout.writeObject(financiamento);
            }
            objout.flush();
            objout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //lendo o arquivo dadosSerializadosFinanciamentos.teste utilizando ObjectInputStream e FileInputStream
        try {
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream("dadosSerializadosFinanciamentos.teste"));
            Object obj;
            System.out.println("Leitura do arquivo dadosSerializadosFinanciamentos.teste:\n");
            while((obj = objin.readObject()) != null) {
                if (obj instanceof Financiamento) {
                    System.out.println(obj);
                }
            }
            objin.close();
        } catch (Exception e) {
            System.out.println("Leitura do arquivo dadosSerializadosFinanciamentos.teste finalizado com sucesso!");
        }
    }
}