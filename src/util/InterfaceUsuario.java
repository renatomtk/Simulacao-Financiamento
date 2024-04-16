package util;

import java.util.Scanner;
public class InterfaceUsuario {
    Scanner sc = new Scanner(System.in); //instanciando o Scanner para a entrada de dados do usuário

    //métodos
    public double solicitarValorImovel() {
        System.out.println("Digite o valor do imóvel: ");
        double valorImovel = sc.nextDouble();
        if (valorImovel < 100000 || valorImovel > 500000) {
            while (valorImovel < 100000 || valorImovel > 500000) {
                System.out.println("Valor do imóvel inválido! Tente novamente.");
                valorImovel = sc.nextDouble();
            }
        }
        return valorImovel;
    }

    public int solicitarPrazoFinanciamento() {
        System.out.println("Digite o prazo do financiamento (em anos): ");
        int prazoFinanciamento = sc.nextInt();
        if (prazoFinanciamento <= 0 || prazoFinanciamento > 35) {
            while (prazoFinanciamento <= 0 || prazoFinanciamento > 35) {
                System.out.println("Prazo do financiamento inválido! Tente novamente.");
                prazoFinanciamento = sc.nextInt();
            }
        }
        return prazoFinanciamento;
    }

    public double solicitarTaxaJuros() {
        System.out.println("Digite o valor da taxa de juros (anual): ");
        double taxaJuros = sc.nextDouble();
        if (taxaJuros <= 0 || taxaJuros > 200) {
            while (taxaJuros <= 0 || taxaJuros > 200) {
                System.out.println("Valor da taxa de juros inválido! Tente novamente.");
                taxaJuros = sc.nextDouble();
            }
        }
        return taxaJuros;
    }
}
