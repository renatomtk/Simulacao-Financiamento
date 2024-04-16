package modelo;

public abstract class Financiamento { //classe abstrata
    //atributos
    protected double valorImovel;
    protected int prazoFinanciamento; //em anos
    protected double taxaJuros; //em anos

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
}
