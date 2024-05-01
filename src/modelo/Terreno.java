package modelo;

public class Terreno extends Financiamento { //subclasse de Financiamento
    //atributos
    private String zona;

    //métodos
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros, String zona) { //construtor
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.zona = zona;
    }

    public String getZona() { //get
        return this.zona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJuros/100) / 12))) * 1.02;
    }

    @Override
    public void dadosFinanciamento() {
        System.out.println("\n----- Dados do financiamento [TERRENO] -----");
        System.out.printf("Valor do imóvel: R$%.2f\n", getValorImovel());
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJuros() + "%");
        System.out.println("Zona: " + getZona());
        System.out.printf("Pagamento mensal: R$%.2f\n", calcularPagamentoMensal());
        System.out.printf("Pagamento total: R$%.2f\n", calcularPagamentoTotal());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("----- Dados do financiamento [TERRENO] -----").append("\n");
        builder.append("Valor do imóvel: ").append(df.format(getValorImovel())).append("\n");
        builder.append("Prazo do financiamento: ").append(getPrazoFinanciamento()).append("\n");
        builder.append("Taxa de juros anual: ").append(getTaxaJuros()).append("\n");
        builder.append("Zona: ").append(getZona()).append("\n");
        builder.append("Pagamento mensal: ").append(df.format(calcularPagamentoMensal())).append("\n");
        builder.append("Pagamento total: ").append(df.format(calcularPagamentoTotal())).append("\n");
        return builder.toString();
    }
}
