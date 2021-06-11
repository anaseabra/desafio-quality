package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HouseResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.RoomDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CalculatorServiceTests {

	private CalculatorService calculatorService = new CalculatorService();

	private HomeDto homeDto;
	private HouseResponseDto houseResponseDto;
	private Map<String, Double> roomAreas;

	@BeforeEach
	void populateHomeDto(){
		homeDto = new HomeDto();
		homeDto.setPropName("Casa de praia");
		homeDto.setPropDistrict("INGLESES");

		List<RoomDto> rooms = new ArrayList<>();
		rooms.add(new RoomDto("Banheiro", 5.5, 3.5));
		rooms.add(new RoomDto("Quarto", 7.0, 7.0));
		rooms.add(new RoomDto("Cozinha", 4.5, 5.6));
		
		homeDto.setRooms(rooms);

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
	void shouldReturnTotalSquareMeters() {
		double totalSquareMeters = calculatorService.getTotalSquareMeters(homeDto);

		assertEquals(93.45, totalSquareMeters);
	}

	@Test
	void shouldReturnHomePrice() {
		double homePrice = calculatorService.getPrice(homeDto);

		assertEquals(74760.0, homePrice);
	}

	@Test()
	void shouldThrowsIllegalArgumentException() {
		homeDto.setPropDistrict("PRAIA");

		assertThrows(IllegalArgumentException.class, () -> {
			calculatorService.getPrice(homeDto);
		});
	}

	@Test
	void shouldReturnBiggestRoom() {
		String roomName = calculatorService.getBiggestRoom(homeDto);

		assertEquals("Quarto", roomName);
	}

	@Test
	void shouldReturnRoomAreas() {
		Map<String, Double> rooms = calculatorService.getRoomAreas(homeDto);

		assertEquals(roomAreas, rooms);
	}

	@Test
	void shouldReturnHouseInformation() {

		HouseResponseDto houseResponse = calculatorService.getHouseInformation(homeDto);

		assertThat(houseResponseDto).usingRecursiveComparison().isEqualTo(houseResponse);
	}
}
