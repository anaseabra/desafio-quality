package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
public class RoomDto {

    @NotNull(message = "Room name is required")
    @Size(max = 30, message = "Room name must be a maximum of 30 characters")
    @Pattern(regexp = "[A-Z].*", message = "Room name must initiate with uppercase")
    private String roomName;

    @NotNull(message = "Room width is required")
    @DecimalMax(value = "25.0", message = "The maximum width allowed per room is 25 meters")
    private double roomWidth;

    @NotNull(message = "Room width is required")
    @DecimalMax(value = "33.0", message = "The maximum length allowed per room is 33 meters.")
    private double roomLength;

    private double squareMeters;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(double roomWidth) {
        this.roomWidth = roomWidth;
    }

    public double getRoomLength() {
        return roomLength;
    }

    public void setRoomLength(double roomLength) {
        this.roomLength = roomLength;
    }

    public double getSquareMeters() {
        return squareMeters = roomWidth * roomLength;
    }

}
