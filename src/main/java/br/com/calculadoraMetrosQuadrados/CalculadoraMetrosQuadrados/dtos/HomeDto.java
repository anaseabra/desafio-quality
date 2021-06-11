package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.dtos;

import br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.utils.District;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class HomeDto {

    @NotNull(message = "Property name is required")
    @Size(max = 30, message = "Property name must be a maximum of 30 characters")
    @Pattern(regexp = "[A-Z].*", message = "Property name must initiate with uppercase")
    private String propName;

    @NotNull(message = "Property district is required")
//    @Size(max = 45, message = "Property district must be a maximum of 45 characters")
    private District propDistrict;

    @Valid
    @NotEmpty(message = "Room list cannot be empty ")
    private List<RoomDto> rooms;

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public District getPropDistrict() {
        return propDistrict;
    }

    public void setPropDistrict(District propDistrict) {
        this.propDistrict = propDistrict;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
