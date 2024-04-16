package main;

import util.InterfaceUsuario; //importando a classe InterfaceUsuario do pacote util
import modelo.Financiamento; //importando a classe Financiamento do pacote modelo

import java.util.ArrayList; //importando o ArrayList da biblioteca java.util

public class Main {
    public static void main(String[] args) { //início da aplicação
        InterfaceUsuario usuario = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<Financiamento>();
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

        System.out.printf("\nValor total de todos os imóveis: R$%.2f",totalImovel); //fornece o valor total dos imóveis
        System.out.printf("\nValor total de todos os financiamentos: R$%.2f",totalFinanciamento); //fornece o valor total dos financiamentos
    }
}