package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.controllers;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.exception.DistrictNotFoundException;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services.CalculatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/houseInformation")
public class CalculatorController {

    private final CalculatorServiceImpl calculatorServiceImpl;

    public CalculatorController(final CalculatorServiceImpl calculatorServiceImpl) {
        this.calculatorServiceImpl = calculatorServiceImpl;
    }

    @PostMapping()
    public ResponseEntity<HomeResponseDto> getHouseInformation(@Valid @RequestBody HomeDto homeDto) throws DistrictNotFoundException {
        return ResponseEntity.status(200).body(calculatorServiceImpl.getHomeInformation(homeDto));
    }


}
