package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.controllers.CalculatorController;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HouseResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private HouseResponseDto houseResponseDto;
    private Map<String, Double> roomAreas;

    @BeforeEach
    void setUp(){
        roomAreas = new HashMap<>();
        roomAreas.put("Banheiro", 19.25);
        roomAreas.put("Quarto", 49.0);
        roomAreas.put("Cozinha", 25.2);

        houseResponseDto = new HouseResponseDto();
        houseResponseDto.setPrice(74760.0);
        houseResponseDto.setTotalSquareMeters(93.45);
        houseResponseDto.setBiggestRoom("Quarto");
        houseResponseDto.setRoomAreas(roomAreas);
    }


    @Test
    void shouldReturnHouseInformation() {
        String request = "{\"propName\": \"Casa de Praia\"," +
                         "\"propDistrict\": \"Ingleses\"," +
                         "\"rooms\": [{\"roomName\": \"Quarto\",\"roomWidth\": 7.0, \"roomLenght\": 10.5}," +
                         "{\"roomName\": \"Cozinha\", \"roomWidth\": 8.5,\"roomLenght\": 8.5}, " +
                         "{\"roomName\": \"Banheiro\",\"roomWidth\": 14.0,\"roomLenght\": 4.0}" +
                         "]" +
                         "}";
        this.mockMvc.perform(
                post("/houseInformation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)).andDo(print()).andExpect(status().isOk())
                .andExpect()

    }

}
