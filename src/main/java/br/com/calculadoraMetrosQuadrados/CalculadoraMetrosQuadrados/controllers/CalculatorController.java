package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.controllers;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/houseInformation")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(final CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping()
    public ResponseEntity<HomeResponseDto> getHouseInformation(@Valid @RequestBody HomeDto homeDto){
        return ResponseEntity.status(200).body(calculatorService.getHomeInformation(homeDto));
    }


}
