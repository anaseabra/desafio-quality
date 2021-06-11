package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos;

public class HouseResponseDto {

    private double totalSquareMeters;
    private double price;
    private String biggestRoom;

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
}
