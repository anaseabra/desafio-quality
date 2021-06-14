package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    private HomeResponseDto homeResponseDto;
    private Map<String, Double> roomAreas;

    @BeforeEach
    void setUp() {
        roomAreas = new HashMap<>();
        roomAreas.put("Banheiro", 56.0);
        roomAreas.put("Quarto", 73.5);
        roomAreas.put("Cozinha", 72.25);

        homeResponseDto = new HomeResponseDto();
        homeResponseDto.setPrice(201750.0);
        homeResponseDto.setTotalSquareMeters(201.75);
        homeResponseDto.setBiggestRoom("Quarto");
        homeResponseDto.setRoomAreas(roomAreas);
    }

    @Test
    void shouldReturnHouseInformation() throws Exception {
        String request = "{\"propName\": \"Casa de Praia\"," +
                "\"propDistrict\": \"Ingleses\"," +
                "\"rooms\": [{\"roomName\": \"Quarto\",\"roomWidth\": 7.0, \"roomLength\": 10.5}," +
                "{\"roomName\": \"Cozinha\", \"roomWidth\": 8.5,\"roomLength\": 8.5}, " +
                "{\"roomName\": \"Banheiro\",\"roomWidth\": 14.0,\"roomLength\": 4.0}" +
                "]" +
                "}";

        this.mockMvc.perform(
                post("/houseInformation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)).andDo(print()).andExpect(status().isOk())
                        .andExpect(jsonPath("$.totalSquareMeters").value(201.75))
                        .andExpect(jsonPath("$.price").value(161400.00));
    }

    @Test
    void shouldThrowMethodArgumentNotValidException() throws Exception {
        String request = "{\"propName\": \"casa de Praia\"," +
                "\"propDistrict\": \"Ingleses\"," +
                "\"rooms\": [{\"roomName\": \"Quarto\",\"roomWidth\": 7.0, \"roomLength\": 10.5}," +
                "{\"roomName\": \"Cozinha\", \"roomWidth\": 8.5,\"roomLength\": 8.5}, " +
                "{\"roomName\": \"Banheiro\",\"roomWidth\": 14.0,\"roomLength\": 4.0}" +
                "]" +
                "}";

        this.mockMvc.perform(
                post("/houseInformation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)).andDo(print())
                        .andExpect(status().isBadRequest());
    }

    @Test
    void shouldThrowIllegalArgumentException() throws Exception {
        String request = "{\"propName\": \"Casa de Praia\"," +
                "\"propDistrict\": \"Campeche\"," +
                "\"rooms\": [{\"roomName\": \"Quarto\",\"roomWidth\": 7.0, \"roomLength\": 10.5}," +
                "{\"roomName\": \"Cozinha\", \"roomWidth\": 8.5,\"roomLength\": 8.5}, " +
                "{\"roomName\": \"Banheiro\",\"roomWidth\": 14.0,\"roomLength\": 4.0}" +
                "]" +
                "}";

        this.mockMvc.perform(
                post("/houseInformation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)).andDo(print())
                        .andExpect(status().isNotFound());
    }
}

