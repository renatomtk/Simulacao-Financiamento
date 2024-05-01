package modelo;

public class Apartamento extends Financiamento { //subclasse de Financiamento
    //atributos
    private double taxaMensal;
    private int meses;
    private int numVagasGaragem;
    private int numAndar;

    //métodos
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJuros, int numVagasGaragem, int numAndar) { //construtor
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.numVagasGaragem = numVagasGaragem;
        this.numAndar = numAndar;
    }

    public int getNumVagasGaragem() { //get
        return this.numVagasGaragem;
    }

    public int getNumAndar() { //get
        return this.numAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        taxaMensal = getTaxaJuros() / (12 * 100); //taxa mensal
        meses = getPrazoFinanciamento() * 12; //financiamento em meses

        return getValorImovel() * (taxaMensal * Math.pow(1 + taxaMensal, meses)) / (Math.pow(1 + taxaMensal, meses) - 1);
    }

    @Override
    public void dadosFinanciamento() {
        System.out.println("\n----- Dados do financiamento [APARTAMENTO] -----");
        System.out.printf("Valor do imóvel: R$%.2f\n", getValorImovel());
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJuros() + "%");
        System.out.println("Número de vagas da garagem: " + getNumVagasGaragem());
        System.out.println("Número do andar: " + getNumAndar());
        System.out.printf("Pagamento mensal: R$%.2f\n", calcularPagamentoMensal());
        System.out.printf("Pagamento total: R$%.2f\n", calcularPagamentoTotal());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("----- Dados do financiamento [APARTAMENTO] -----").append("\n");
        builder.append("Valor do imóvel: ").append(df.format(getValorImovel())).append("\n");
        builder.append("Prazo do financiamento: ").append(getPrazoFinanciamento()).append("\n");
        builder.append("Taxa de juros anual: ").append(getTaxaJuros()).append("\n");
        builder.append("Número de vagas da garagem: ").append(getNumVagasGaragem()).append("\n");
        builder.append("Número do andar: ").append(getNumAndar()).append("\n");
        builder.append("Pagamento mensal: ").append(df.format(calcularPagamentoMensal())).append("\n");
        builder.append("Pagamento total: ").append(df.format(calcularPagamentoTotal())).append("\n");
        return builder.toString();
    }
}
