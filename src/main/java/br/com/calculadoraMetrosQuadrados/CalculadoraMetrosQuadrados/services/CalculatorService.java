package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HouseResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.RoomDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculatorService {

    public HouseResponseDto getHouseInformation(HomeDto home){
        HouseResponseDto houseInformation = new HouseResponseDto();
        houseInformation.setTotalSquareMeters(getTotalSquareMeters(home));
        houseInformation.setBiggestRoom(getBiggestRoom(home));
        houseInformation.setPrice(getPrice(home));

        return houseInformation;

    }

    public double getTotalSquareMeters(HomeDto home){
        List<RoomDto> comodos = home.getRooms();
        double area=0;
        for(RoomDto c: comodos){
            area+=c.getRoomWidth()*c.getRoomLength();
        }
        return area;
    }

    public double getPrice(HomeDto home){
        return getTotalSquareMeters(home)*home.getPropDistrict().getPricePerSquareMeter();
    }

    public String getBiggestRoom(HomeDto home){
        List<RoomDto> comodos = home.getRooms();
        RoomDto comodo = comodos.stream().max((comodo1, comodo2)->{
            double areaC1= comodo1.getRoomWidth()*comodo1.getRoomLength();
            double areaC2= comodo2.getRoomWidth()*comodo2.getRoomLength();
            return (int) (areaC1-areaC2);
        }).get();

        return comodo.getRoomName();
    }

    public Map<String, Double> getRoomAreas(HomeDto casa){
        List<RoomDto> comodos = casa.getRooms();
        Map<String, Double> areasComodos= new HashMap<String, Double>();
        double area;
        for (RoomDto c: comodos){
            area= c.getRoomWidth()*c.getRoomLength();
            areasComodos.put(c.getRoomName(),area);
        }
        return areasComodos;
    }
}
