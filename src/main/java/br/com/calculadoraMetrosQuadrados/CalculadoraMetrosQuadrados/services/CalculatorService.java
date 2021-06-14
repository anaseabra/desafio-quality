package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.exception.DistrictNotFoundException;

import java.util.Map;

public interface CalculatorService {

    HomeResponseDto getHomeInformation(HomeDto home) throws DistrictNotFoundException;
    double getTotalSquareMeters(HomeDto home);
    double getPrice(HomeDto home) throws DistrictNotFoundException;
    String getBiggestRoom(HomeDto home);
    Map<String, Double> getRoomAreas(HomeDto casa);

}
