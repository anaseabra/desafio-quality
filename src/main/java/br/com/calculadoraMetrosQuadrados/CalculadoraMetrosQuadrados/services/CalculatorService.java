package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.services;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.HomeResponseDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos.RoomDto;
import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.utils.District;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class CalculatorService {

    public HomeResponseDto getHomeInformation(HomeDto home){
        HomeResponseDto homeInformation = new HomeResponseDto();
        homeInformation.setTotalSquareMeters(getTotalSquareMeters(home));
        homeInformation.setBiggestRoom(getBiggestRoom(home));
        homeInformation.setPrice(getPrice(home));
        homeInformation.setRoomAreas(getRoomAreas(home));

        return homeInformation;

    }

    public double getTotalSquareMeters(HomeDto home){
        List<RoomDto> rooms = home.getRooms();
        double area=0;
        for(RoomDto c: rooms){
            area+=c.getRoomWidth()*c.getRoomLength();
        }
        return area;
    }

    public double getPrice(HomeDto home){

        District district = District.valueOf(home.getPropDistrict().toUpperCase(Locale.ROOT));

        return getTotalSquareMeters(home)*district.getPricePerSquareMeter();
    }

    public String getBiggestRoom(HomeDto home){
        List<RoomDto> rooms = home.getRooms();
        RoomDto room = rooms.stream().max((room1, room2)->{
            double areaC1= room1.getRoomWidth()*room1.getRoomLength();
            double areaC2= room2.getRoomWidth()*room2.getRoomLength();
            return (int) (areaC1-areaC2);
        }).get();

        return room.getRoomName();
    }

    public Map<String, Double> getRoomAreas(HomeDto casa){
        List<RoomDto> rooms = casa.getRooms();
        Map<String, Double> roomAreas= new HashMap<String, Double>();
        double area;
        for (RoomDto c: rooms){
            area= c.getRoomWidth()*c.getRoomLength();
            roomAreas.put(c.getRoomName(),area);
        }
        return roomAreas;
    }
}
