package util;

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner sc = new Scanner(System.in); //instanciando o Scanner para a entrada de dados do usuário

    //métodos
    public double solicitarValorImovel() {
        double valorImovel;
        while (true) {
            try { //utilizando exceções para tratativa de erros
                System.out.println("Digite o valor do imóvel: ");
                valorImovel = sc.nextDouble();
                if (valorImovel < 100000 || valorImovel > 500000) {
                    System.out.println("O valor do imóvel deve estar entre R$100000 e R$500000."); //regra de negócio
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um valor válido.");
                sc.nextLine();
            }
        }
        return valorImovel;
    }

    public int solicitarPrazoFinanciamento() {
        int prazoFinanciamento;
        while (true) {
            try { //utilizando exceções para tratativa de erros
                System.out.println("Digite o prazo do financiamento (em anos): ");
                prazoFinanciamento = sc.nextInt();
                if (prazoFinanciamento <= 0 || prazoFinanciamento > 35) {
                    System.out.println("O prazo do financiamento deve estar entre 1 e 35."); //regra de negócio
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um valor válido.");
                sc.nextLine();
            }
        }
        return prazoFinanciamento;
    }

    public double solicitarTaxaJuros() {
        int taxaJuros;
        while (true) {
            try { //utilizando exceções para tratativa de erros
                System.out.println("Digite o valor da taxa de juros (anual): ");
                taxaJuros = sc.nextInt();
                if (taxaJuros <= 0 || taxaJuros > 200) {
                    System.out.println("A taxa de juros deve estar entre 1 e 200."); //regra de negócio
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um valor válido.");
                sc.nextLine();
            }
        }
        return taxaJuros;
    }
}