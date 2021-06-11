package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos;

import java.util.Map;

public class HomeResponseDto {

    private double totalSquareMeters;
    private double price;
    private String biggestRoom;
    private Map<String, Double> roomAreas;

    public double getTotalSquareMeters() {
        return totalSquareMeters;
    }

    public void setTotalSquareMeters(double totalSquareMeters) {
        this.totalSquareMeters = totalSquareMeters;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBiggestRoom() {
        return biggestRoom;
    }

    public void setBiggestRoom(String biggestRoom) {
        this.biggestRoom = biggestRoom;
    }

    public Map<String, Double> getRoomAreas() {
        return roomAreas;
    }

    public void setRoomAreas(Map<String, Double> roomAreas) {
        this.roomAreas = roomAreas;
    }
}
