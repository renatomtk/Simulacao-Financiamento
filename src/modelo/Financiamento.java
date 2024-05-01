package modelo;

import java.io.Serializable; //importando o Serializable para serializar dados
import java.text.DecimalFormat; //importando o DecimalFormat para formatar os valores que serão salvos no arquivo dadosFinanciamento.txt com duas casas decimais

public abstract class Financiamento implements Serializable { //classe abstrata || objetos da classe podem ser serializados
    //atributos
    protected double valorImovel;
    protected int prazoFinanciamento; //em anos
    protected double taxaJuros; //em anos
    DecimalFormat df = new DecimalFormat("#0.00");

    //métodos
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJuros) { //construtor
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJuros = taxaJuros;
    }

    public double getValorImovel() { //get
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() { //get
        return this.prazoFinanciamento;
    }

    public double getTaxaJuros() { //get
        return this.taxaJuros;
    }

    public abstract double calcularPagamentoMensal(); //método abstrato

    public double calcularPagamentoTotal() {
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public abstract void dadosFinanciamento(); //método abstrato

    public abstract String toString(); //método abstrato
}
