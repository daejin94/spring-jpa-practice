package test.example.jpa.Exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionDto {

    String message;
    Integer statusCode;

    public static ExceptionDto of(String message, Integer statusCode) {
        return new ExceptionDto(message, statusCode);
    }

}
