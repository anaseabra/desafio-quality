package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.utils;

public enum District {

    INGLESES(800.0),
    CANASVIEIRAS(760.0),
    ITACORUBI(900.0),
    AGRONOMICA(1000.0),
    LAGOA_DA_CONCEICAO(750.0);

    private final double pricePerSquareMeter;

    District(double pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public double getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

}
