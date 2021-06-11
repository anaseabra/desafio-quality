package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.exception;

public class DistrictNotFoundException extends RuntimeException{

    public DistrictNotFoundException() {
    }

    public DistrictNotFoundException(String message) {
        super(message);
    }
}
