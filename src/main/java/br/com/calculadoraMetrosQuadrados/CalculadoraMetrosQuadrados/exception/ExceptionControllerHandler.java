package br.com.calculadoraMetrosQuadrados.CalculadoraMetrosQuadrados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionControllerHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    ErrorInfo handleDistrictNotFoundException() {
        return new ErrorInfo(new Date(), "District not found or does not exist");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ErrorInfo handleDistrictNotFoundException(MethodArgumentNotValidException e) {
        StringBuilder stringBuilder = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            stringBuilder.append(fieldError.getField());
            stringBuilder.append(": ");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append(" | ");
        });

        return new ErrorInfo(new Date(), stringBuilder.toString());
    }

}
