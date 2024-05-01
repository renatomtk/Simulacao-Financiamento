package modelo;

import util.AcrescimoMaiorDoQueJurosException; //importando a exceção da aplicação do pacote util

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

    public void acrescimoMaiorDoQueJuros(double acrescimo, double juros) throws AcrescimoMaiorDoQueJurosException { //throws
        if (acrescimo > juros) {
            throw new AcrescimoMaiorDoQueJurosException("O valor do acréscimo dado é maior do que o valor dos juros da mensalidade."); //throw new
        }
    }
    @Override
    public double calcularPagamentoMensal() {
        double acrescimo = 80; //valor do acréscimo base
        double juros = ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJuros / 100) / 12))) - (this.valorImovel / (this.prazoFinanciamento * 12)); //valor dos juros mensais do financiamento

        try {
            acrescimoMaiorDoQueJuros(acrescimo, juros);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            acrescimo = juros; //caso o acréscimo for maior do que a taxa de juros, o valor do acréscimo será o valor da taxa de juros
        }

        return ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJuros / 100) / 12))) + acrescimo;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("----- Dados do financiamento [CASA] -----").append("\n");
        builder.append("Valor do imóvel: ").append(df.format(getValorImovel())).append("\n");
        builder.append("Prazo do financiamento: ").append(getPrazoFinanciamento()).append("\n");
        builder.append("Taxa de juros anual: ").append(getTaxaJuros()).append("\n");
        builder.append("Área construída: ").append(getAreaConstruida()).append("\n");
        builder.append("Área do terreno: ").append(getAreaTerreno()).append("\n");
        builder.append("Pagamento mensal: ").append(df.format(calcularPagamentoMensal())).append("\n");
        builder.append("Pagamento total: ").append(df.format(calcularPagamentoTotal())).append("\n");
        return builder.toString();
    }
}