package modelo;

public class Casa extends Financiamento { //subclasse de Financiamento
    //atributos
    private double areaConstruida;
    private double areaTerreno;

    //métodos
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJuros, double areaConstruida, double areaTerreno) { //construtor
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() { //get
        return this.areaConstruida;
    }

    public double getAreaTerreno() { //get
        return this.areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        return ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJuros/100) / 12))) + 80;
    }

    @Override
    public void dadosFinanciamento() {
        System.out.println("\n----- Dados do financiamento [CASA] -----");
        System.out.printf("Valor do imóvel: R$%.2f\n", getValorImovel());
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJuros() + "%");
        System.out.println("Área construída: " + getAreaConstruida() + " m2");
        System.out.println("Área do terreno: " + getAreaTerreno() + " m2");
        System.out.printf("Pagamento mensal: R$%.2f\n", calcularPagamentoMensal());
        System.out.printf("Pagamento total: R$%.2f\n", calcularPagamentoTotal());
    }
}
